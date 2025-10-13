package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*

data class Paladin(
    override val name: String = "Paladin",
    override val healthDice: DiceType = DiceType.d10,
    override val primaryAbility: AbilityScore = AbilityScore.STRENGTH,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.HEAVY,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE,
        WeaponProficiency.MARTIAL
    )
) : CharacterClass
