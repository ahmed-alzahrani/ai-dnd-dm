package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ItemType
import com.aidnd.game_engine.models.equipment.enums.ShieldType

data class Shield(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null,
    val shieldType: ShieldType,
    val armorClassBonus: Int
) : Item {
    override val itemType = ItemType.SHIELD
}
