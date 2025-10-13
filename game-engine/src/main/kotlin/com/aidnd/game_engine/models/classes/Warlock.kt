package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*

data class Warlock(
    override val name: String = "Warlock",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.CHARISMA,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.LIGHT,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE
    )
) : CharacterClass
