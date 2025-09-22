package com.aidnd.game_engine.dto

import com.aidnd.game_engine.models.DiceResult

data class DiceRollResponse(
    val diceResults: List<DiceResult>,
    val total: Int
)