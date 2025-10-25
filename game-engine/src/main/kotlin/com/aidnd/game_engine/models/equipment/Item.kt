package com.aidnd.game_engine.models.equipment

interface Item {
    val name: String
    val weight: Double
    val value: Int
    val description: String?
    val buffs: ItemBuffs?
}
