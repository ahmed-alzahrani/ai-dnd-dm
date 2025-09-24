package com.aidnd.game_engine.models

import com.aidnd.game_engine.models.races.*

interface Race {
    val name: String
    val size: Size
    val speed: Int
    val abilityScoreBonuses: Map<AbilityScore, Int>
    val darkVision: Int get() = 0
    
    companion object {
        fun fromString(raceString: String): Race {
            return when (raceString.lowercase()) {
                "human" -> Human()
                "elf" -> Elf()
                "dwarf" -> Dwarf()
                "halfling" -> Halfling()
                "dragonborn" -> Dragonborn()
                "gnome" -> Gnome()
                else -> throw IllegalArgumentException("Unknown race: $raceString")
            }
        }
    }
}
