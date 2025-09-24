package com.aidnd.game_engine.models

import com.aidnd.game_engine.validation.CharacterValidation
import com.aidnd.game_engine.dto.CharacterResponse

class Character(
    val id: Int,
    var name: String,
    var level: Int = 1,
    var race: Race,
    var characterClass: String,
    var maxHealth: Int,
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int,
    var armorClass: Int
) {
    var currentHealth: Int = maxHealth

    init {
        CharacterValidation.validateString(value = name, fieldName = "Name")
        CharacterValidation.validateString(value = characterClass, fieldName = "Class")
        CharacterValidation.validateAbilityScores(strength, dexterity, constitution, intelligence, wisdom, charisma)
        CharacterValidation.validateAboveZero(value = maxHealth, fieldName = "Max Health")
        CharacterValidation.validateAboveZero(value = level, fieldName = "Level")
        CharacterValidation.validateAboveZero(value = armorClass, fieldName = "Armor Class")
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

    fun toResponse(): CharacterResponse {
        return CharacterResponse(
            id = this.id,
            name = this.name,
            level = this.level,
            race = this.race.name,
            characterClass = this.characterClass,
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