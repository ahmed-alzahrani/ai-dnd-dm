package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ItemType
import com.aidnd.game_engine.models.enums.DamageType
import com.aidnd.game_engine.models.enums.DiceType

data class Weapon(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null,
    val damageDice: DiceType,
    val damageType: DamageType
) : Item {
    override val itemType = ItemType.WEAPON
}
