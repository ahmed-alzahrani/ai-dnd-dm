package com.aidnd.game_engine.dto

data class CharacterResponse(
    val id: Int,
    val name: String,
    val level: Int,
    val race: String,
    val characterClass: String,
    val maxHealth: Int,
    val currentHealth: Int,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val armorClass: Int
)
