package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*

data class Cleric(
    override val name: String = "Cleric",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.WISDOM,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.MEDIUM,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE
    )
) : CharacterClass
