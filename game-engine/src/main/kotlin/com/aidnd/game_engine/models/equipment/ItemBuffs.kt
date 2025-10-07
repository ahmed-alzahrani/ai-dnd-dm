package com.aidnd.game_engine.models.equipment

data class ItemBuffs(
    val ac: Int = 0,
    val str: Int = 0,
    val dex: Int = 0,
    val con: Int = 0,
    val int: Int = 0,
    val wis: Int = 0,
    val cha: Int = 0,
    val attack: Int? = null,
    val damage: Int? = null
)
