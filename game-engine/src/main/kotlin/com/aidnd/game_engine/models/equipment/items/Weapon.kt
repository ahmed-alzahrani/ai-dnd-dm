package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.dto.equipment.WeaponResponse
import com.aidnd.game_engine.models.enums.*
import com.aidnd.game_engine.models.equipment.Item
import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.WeaponType

data class Weapon(
    override val name: String,
    override val weight: Double,
    override val value: Int,
    override val description: String? = null,
    override val buffs: ItemBuffs? = null,
    val weaponType: WeaponType,
    val damageDice: DiceType,
    val damageType: DamageType
) : Item {
    fun toResponse(): WeaponResponse {
        return WeaponResponse(
            name = this.name,
            weight = this.weight,
            value = this.value,
            description = this.description,
            weaponType = this.weaponType.name,
            damageDice = this.damageDice.name,
            damageType = this.damageType.name
        )
    }
}
