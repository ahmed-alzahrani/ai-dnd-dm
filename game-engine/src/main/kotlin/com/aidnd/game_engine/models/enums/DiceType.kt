package com.aidnd.game_engine.models.enums

enum class DiceType(val sides: Int) {
    d3(3),
    d4(4),
    d6(6),
    d8(8),
    d10(10),
    d12(12),
    d20(20),
    d100(100);
    
    companion object {
        val validSides = values().map { it.sides }
    }
}
