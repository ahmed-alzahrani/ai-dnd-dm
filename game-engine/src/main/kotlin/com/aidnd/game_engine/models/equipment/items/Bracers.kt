package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.BracersResponse
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs

data class Bracers(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null
) : Item {
    fun toResponse(): BracersResponse {
        return BracersResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description
        )
    }
}
