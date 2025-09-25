package com.aidnd.game_engine.dto

import com.aidnd.game_engine.validation.CharacterValidation

data class CreateCharacterRequest(
    val id: Int,
    val name: String,
    val level: Int = 1,
    val race: String,
    val characterClass: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
) {
    init {
        CharacterValidation.validateString(value = name, fieldName = "Name")
        CharacterValidation.validateString(value = race, fieldName = "Race")
        CharacterValidation.validateString(value = characterClass, fieldName = "Class")
        CharacterValidation.validateAbilityScores(strength, dexterity, constitution, intelligence, wisdom, charisma)
        CharacterValidation.validateAboveZero(value = id, fieldName = "ID")
        CharacterValidation.validateAboveZero(value = level, fieldName = "Level")
    }
}
