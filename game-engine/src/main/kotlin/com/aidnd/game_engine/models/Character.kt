package com.aidnd.game_engine.models

import com.aidnd.game_engine.validation.CharacterValidation
import com.aidnd.game_engine.dto.CharacterResponse
import com.aidnd.game_engine.models.equipment.Equipment

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
    var armorClass: Int = 10 + getAbilityModifier(AbilityScore.DEXTERITY) // Base AC: 10 + DEX modifier
    var equipment: Equipment = Equipment() // Character starts with no equipment

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
}