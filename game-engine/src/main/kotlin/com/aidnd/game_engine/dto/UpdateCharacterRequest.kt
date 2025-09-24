package com.aidnd.game_engine.dto

import com.aidnd.game_engine.validation.CharacterValidation

data class UpdateCharacterRequest(
    val name: String? = null,
    val level: Int? = null,
    val race: String? = null,
    val characterClass: String? = null,
    val maxHealth: Int? = null,
    val currentHealth: Int? = null,
    val strength: Int? = null,
    val dexterity: Int? = null,
    val constitution: Int? = null,
    val intelligence: Int? = null,
    val wisdom: Int? = null,
    val charisma: Int? = null,
    val armorClass: Int? = null
) {
    init {
        name?.let { CharacterValidation.validateString(value = it, fieldName = "Name") }
        race?.let { CharacterValidation.validateString(value = it, fieldName = "Race") }
        characterClass?.let { CharacterValidation.validateString(value = it, fieldName = "Class") }
        
        val abilityScores = listOfNotNull(strength, dexterity, constitution, intelligence, wisdom, charisma)
        if (abilityScores.isNotEmpty()) {
            CharacterValidation.validateAbilityScores(*abilityScores.toIntArray())
        }
        
        maxHealth?.let { CharacterValidation.validateAboveZero(value = it, fieldName = "Max Health") }
        level?.let { CharacterValidation.validateAboveZero(value = it, fieldName = "Level") }
        armorClass?.let { CharacterValidation.validateAboveZero(value = it, fieldName = "Armor Class") }
    }
}
