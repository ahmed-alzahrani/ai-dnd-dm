package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*
import com.aidnd.game_engine.models.equipment.enums.WeaponType

data class Dwarf(
    override val name: String = "Dwarf",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 25,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.CONSTITUTION to 2
    ),
    override val darkVision: Int = 60,
    override val weaponProficiencies: Set<WeaponType> = setOf(
        WeaponType.BATTLEAXE,
        WeaponType.HANDAXE,
        WeaponType.LIGHT_HAMMER,
        WeaponType.WARHAMMER
    )
) : Race
