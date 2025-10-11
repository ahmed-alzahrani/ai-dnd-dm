package com.aidnd.game_engine.models

import com.aidnd.game_engine.models.equipment.enums.WeaponType
import com.aidnd.game_engine.models.races.*

interface Race {
    val name: String
    val size: Size
    val speed: Int
    val abilityScoreBonuses: Map<AbilityScore, Int>
    val darkVision: Int get() = 0
    val weaponProficiencies: Set<WeaponType> get() = emptySet()
    
    companion object {
        fun fromString(raceString: String): Race {
            return when (raceString.lowercase()) {
                "human" -> Human()
                "elf" -> Elf()
                "dwarf" -> Dwarf()
                "halfling" -> Halfling()
                "dragonborn" -> Dragonborn()
                "gnome" -> Gnome()
                "half-elf" -> HalfElf()
                "half-orc" -> HalfOrc()
                "tiefling" -> Tiefling()
                else -> throw IllegalArgumentException("Unknown race: $raceString")
            }
        }
    }
}
