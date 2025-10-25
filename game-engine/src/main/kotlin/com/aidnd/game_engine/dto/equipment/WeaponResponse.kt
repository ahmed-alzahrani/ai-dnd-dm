package com.aidnd.game_engine.dto.equipment

data class WeaponResponse(
    val name: String,
    val weight: Double,
    val value: Int,
    val description: String?,
    val weaponType: String,
    val damageDice: String,
    val damageType: String
)
