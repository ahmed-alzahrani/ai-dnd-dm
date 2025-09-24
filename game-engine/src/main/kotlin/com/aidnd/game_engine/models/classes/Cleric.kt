package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.ArmorProficiency
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.DiceType

data class Cleric(
    override val name: String = "Cleric",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.WISDOM,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.MEDIUM
) : CharacterClass
