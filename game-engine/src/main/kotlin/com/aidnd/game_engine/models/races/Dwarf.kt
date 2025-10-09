package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class Dwarf(
    override val name: String = "Dwarf",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 25,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.CONSTITUTION to 2
    ),
    override val darkVision: Int = 60
) : Race
