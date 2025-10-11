package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.enums.ArmorProficiency
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ArmorType
import com.aidnd.game_engine.models.equipment.enums.ItemType

data class Armor(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null,
    val armorType: ArmorType,
    val proficiencyRequired: ArmorProficiency,
    val baseAC: Int,
    val maxDexBonus: Int? = null,
    val stealthDisadvantage: Boolean = false
) : Item {
    override val itemType = ItemType.ARMOR
}
