package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class Gnome(
    override val name: String = "Gnome",
    override val size: Size = Size.SMALL,
    override val speed: Int = 25,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.INTELLIGENCE to 2
    ),
    override val darkVision: Int = 60
) : Race
