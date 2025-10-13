package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*
import com.aidnd.game_engine.models.equipment.enums.WeaponType

data class Rogue(
    override val name: String = "Rogue",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.DEXTERITY,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.LIGHT,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE
    ),
    override val specificWeaponProficiencies: Set<WeaponType> = setOf(
        WeaponType.HAND_CROSSBOW,
        WeaponType.LONGSWORD,
        WeaponType.RAPIER,
        WeaponType.SHORTSWORD
    )
) : CharacterClass
