package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.Race
import com.aidnd.game_engine.models.Size

data class Halfling(
    override val name: String = "Halfling",
    override val size: Size = Size.SMALL,
    override val speed: Int = 25,
    override val abilityScoreBonuses: Map<AbilityScore, Int> = mapOf(
        AbilityScore.DEXTERITY to 2
    )
) : Race
