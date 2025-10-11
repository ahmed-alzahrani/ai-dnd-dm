package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.ArmorProficiency
import com.aidnd.game_engine.models.enums.DiceType

data class Druid(
    override val name: String = "Druid",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.WISDOM,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.MEDIUM
) : CharacterClass
