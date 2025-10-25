package com.aidnd.game_engine.dto.equipment

data class ShieldResponse(
    val name: String,
    val weight: Double,
    val value: Int,
    val description: String?,
    val shieldType: String,
    val armorClassBonus: Int
)
