package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.models.equipment.enums.ItemType

interface Item {
    val name: String
    val weight: Double
    val value: Int
    val description: String?
    val itemType: ItemType
    val buffs: ItemBuffs?
}
