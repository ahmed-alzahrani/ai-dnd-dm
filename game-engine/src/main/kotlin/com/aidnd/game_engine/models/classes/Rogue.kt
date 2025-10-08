package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.enums.ArmorProficiency
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.DiceType

data class Rogue(
    override val name: String = "Rogue",
    override val healthDice: DiceType = DiceType.d8,
    override val primaryAbility: AbilityScore = AbilityScore.DEXTERITY,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.LIGHT
) : CharacterClass
