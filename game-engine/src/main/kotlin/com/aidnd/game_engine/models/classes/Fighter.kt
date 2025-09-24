package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.ArmorProficiency
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.DiceType

data class Fighter(
    override val name: String = "Fighter",
    override val healthDice: DiceType = DiceType.d10,
    override val primaryAbility: AbilityScore = AbilityScore.STRENGTH,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.HEAVY
) : CharacterClass
