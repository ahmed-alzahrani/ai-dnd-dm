package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.CloakResponse
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs

data class Cloak(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null
) : Item {
    fun toResponse(): CloakResponse {
        return CloakResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description
        )
    }
}
