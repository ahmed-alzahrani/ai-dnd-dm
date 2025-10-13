package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class Tiefling(
    override val name: String = "Tiefling",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.CHARISMA to 2,
        AbilityScore.INTELLIGENCE to 1
    ),
    override val darkVision: Int = 60
) : Race
