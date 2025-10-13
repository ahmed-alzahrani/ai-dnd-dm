package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class HalfElf(
    override val name: String = "Half-Elf",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.CHARISMA to 2
    ),
    override val darkVision: Int = 60
) : Race
