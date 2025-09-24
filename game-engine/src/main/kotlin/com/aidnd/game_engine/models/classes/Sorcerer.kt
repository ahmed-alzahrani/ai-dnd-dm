package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.ArmorProficiency
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.DiceType

data class Sorcerer(
    override val name: String = "Sorcerer",
    override val healthDice: DiceType = DiceType.d6,
    override val primaryAbility: AbilityScore = AbilityScore.CHARISMA,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.LIGHT
) : CharacterClass
