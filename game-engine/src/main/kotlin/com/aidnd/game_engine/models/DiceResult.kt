package com.aidnd.game_engine.models

data class DiceResult(
    val sides: Int,
    val count: Int,
    val rolls: List<Int>,
    val total: Int
)