package com.aidnd.game_engine.models

data class DiceSpec(
    val sides: Int,
    val count: Int
) {
    init {
        require(sides in DiceType.validSides) {
            "Invalid dice type: $sides. Valid types: ${DiceType.validSides}"
        }
        require(count > 0) {
            "Dice count must be positive, got: $count"
        }
    }
}