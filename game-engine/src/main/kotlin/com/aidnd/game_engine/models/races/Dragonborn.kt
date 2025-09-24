package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.Race
import com.aidnd.game_engine.models.Size

data class Dragonborn(
    override val name: String = "Dragonborn",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 30,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.STRENGTH to 2,
        AbilityScore.CHARISMA to 1
    )
) : Race
