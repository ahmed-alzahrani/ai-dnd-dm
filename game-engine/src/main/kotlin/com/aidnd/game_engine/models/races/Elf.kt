package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.*

data class Elf(
    override val name: String = "Elf",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.DEXTERITY to 2
    ),
    override val darkVision: Int = 60
) : Race
