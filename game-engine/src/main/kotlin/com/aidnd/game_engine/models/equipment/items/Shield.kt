package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.ShieldResponse
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
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
    fun toResponse(): ShieldResponse {
        return ShieldResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description,
            shieldType = this.shieldType.name,
            armorClassBonus = this.armorClassBonus
        )
    }
}
