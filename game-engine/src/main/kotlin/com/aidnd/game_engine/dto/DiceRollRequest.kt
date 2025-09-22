package com.aidnd.game_engine.dto

import com.aidnd.game_engine.models.DiceSpec

data class DiceRollRequest(
    val dice: List<DiceSpec>
)