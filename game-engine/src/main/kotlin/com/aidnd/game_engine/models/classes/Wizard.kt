package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*

data class Wizard(
    override val name: String = "Wizard",
    override val healthDice: DiceType = DiceType.d6,
    override val primaryAbility: AbilityScore = AbilityScore.INTELLIGENCE,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.LIGHT,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE
    )
) : CharacterClass
