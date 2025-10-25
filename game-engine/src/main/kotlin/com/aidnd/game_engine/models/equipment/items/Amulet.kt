package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.AmuletResponse
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs

data class Amulet(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null
) : Item {
    fun toResponse(): AmuletResponse {
        return AmuletResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description
        )
    }
}
