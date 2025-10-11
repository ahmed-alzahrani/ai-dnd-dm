package com.aidnd.game_engine.models.equipment

data class ItemBuffs(
    val armorClass: Int = 0,
    val strength: Int = 0,
    val dexterity: Int = 0,
    val constitution: Int = 0,
    val intelligence: Int = 0,
    val wisdom: Int = 0,
    val charisma: Int = 0,
    val attack: Int? = null,
    val damage: Int? = null
)
