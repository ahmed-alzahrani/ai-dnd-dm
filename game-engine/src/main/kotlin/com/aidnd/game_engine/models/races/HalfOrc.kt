package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class HalfOrc(
    override val name: String = "Half-Orc",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.STRENGTH to 2,
        AbilityScore.CONSTITUTION to 1
    ),
    override val darkVision: Int = 60
) : Race
