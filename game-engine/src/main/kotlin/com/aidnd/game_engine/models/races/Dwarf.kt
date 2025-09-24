package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.Race
import com.aidnd.game_engine.models.Size

data class Dwarf(
    override val name: String = "Dwarf",
    override val size: Size = Size.MEDIUM,
    override val speed: Int = 25,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.CONSTITUTION to 2
    )
) : Race
