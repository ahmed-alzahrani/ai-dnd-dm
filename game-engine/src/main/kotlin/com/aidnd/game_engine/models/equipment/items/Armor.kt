package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.ArmorResponse
import com.aidnd.game_engine.models.enums.ArmorProficiency
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ArmorType

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
    fun toResponse(): ArmorResponse {
        return ArmorResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description,
            armorType = this.armorType.name,
            baseAC = this.baseAC,
            maxDexBonus = this.maxDexBonus,
            stealthDisadvantage = this.stealthDisadvantage
        )
    }
}
