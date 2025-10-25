package com.aidnd.game_engine.dto.equipment

data class ArmorResponse(
    val name: String,
    val weight: Double,
    val value: Int,
    val description: String?,
    val armorType: String,
    val baseAC: Int,
    val maxDexBonus: Int?,
    val stealthDisadvantage: Boolean
)
