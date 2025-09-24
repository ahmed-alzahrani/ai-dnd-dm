package com.aidnd.game_engine.models

enum class AbilityScore(val displayName: String) {
    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    CONSTITUTION("Constitution"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    CHARISMA("Charisma");
    
    // caluclation for any ability score modifier
    fun getModifier(score: Int): Int = (score - 10) / 2
}
