package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.Race
import com.aidnd.game_engine.models.Size

data class Human(
    override val name: String = "Human",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.STRENGTH to 1,
        AbilityScore.DEXTERITY to 1,
        AbilityScore.CONSTITUTION to 1,
        AbilityScore.INTELLIGENCE to 1,
        AbilityScore.WISDOM to 1,
        AbilityScore.CHARISMA to 1
    )
) : Race
