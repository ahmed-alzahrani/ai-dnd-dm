package com.aidnd.game_engine.models

import com.aidnd.game_engine.dto.CharacterResponse
import com.aidnd.game_engine.models.equipment.Equipment
import com.aidnd.game_engine.models.equipment.StartingEquipmentFactory
import com.aidnd.game_engine.models.equipment.items.*
import com.aidnd.game_engine.validation.CharacterValidation
import kotlin.math.min

class Character(
    val id: Int,
    var name: String,
    var level: Int = 1,
    var race: Race,
    var characterClass: CharacterClass,
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int
) {
    var maxHealth: Int = characterClass.healthDice.sides + getAbilityModifier(AbilityScore.CONSTITUTION)
    var currentHealth: Int = maxHealth
    var equipment: Equipment = StartingEquipmentFactory.getEquipmentForClass(characterClass)
    var armorClass: Int = calculateArmorClass()

    init {
        CharacterValidation.validateString(value = name, fieldName = "Name")
        CharacterValidation.validateAbilityScores(strength, dexterity, constitution, intelligence, wisdom, charisma)
        CharacterValidation.validateAboveZero(value = level, fieldName = "Level")
    }

    fun getAbilityScore(ability: AbilityScore): Int {
        val baseScore = when (ability) {
            AbilityScore.STRENGTH -> strength
            AbilityScore.DEXTERITY -> dexterity
            AbilityScore.CONSTITUTION -> constitution
            AbilityScore.INTELLIGENCE -> intelligence
            AbilityScore.WISDOM -> wisdom
            AbilityScore.CHARISMA -> charisma
        }
        return baseScore + (race.abilityScoreBonuses[ability] ?: 0)
    }
    
    fun getAbilityModifier(ability: AbilityScore): Int {
        return ability.getModifier(getAbilityScore(ability))
    }
    
    fun getDarkVision(): Int = race.darkVision

    fun hasWeaponProficiency(weapon: Weapon): Boolean {
        return weapon.weaponType.proficiency in characterClass.weaponProficiencies ||
               weapon.weaponType in characterClass.specificWeaponProficiencies ||
               weapon.weaponType in race.weaponProficiencies
    }

    fun toResponse(): CharacterResponse {
        return CharacterResponse(
            id = this.id,
            name = this.name,
            level = this.level,
            race = this.race.name,
            characterClass = this.characterClass.name,
            maxHealth = this.maxHealth,
            currentHealth = this.currentHealth,
            strength = this.strength,
            dexterity = this.dexterity,
            constitution = this.constitution,
            intelligence = this.intelligence,
            wisdom = this.wisdom,
            charisma = this.charisma,
            armorClass = this.armorClass
        )
    }

    private fun calculateArmorClass(): Int {
        val armor = equipment.armor
        val shield = equipment.offHand
        
        // Base AC from armor or default to 10
        val baseAC = armor?.baseAC ?: 10
        
        // DEX modifier (capped by armor's maxDexBonus if applicable)
        val dexModifier = if (armor?.maxDexBonus != null) {
            min(getAbilityModifier(AbilityScore.DEXTERITY), armor.maxDexBonus)
        } else {
            getAbilityModifier(AbilityScore.DEXTERITY)
        }
        
        val shieldBonus = shield?.armorClassBonus ?: 0
        
        val equipmentBuff = (armor?.buffs?.armorClass ?: 0) + (shield?.buffs?.armorClass ?: 0)
        
        return baseAC + dexModifier + shieldBonus + equipmentBuff
    }
}