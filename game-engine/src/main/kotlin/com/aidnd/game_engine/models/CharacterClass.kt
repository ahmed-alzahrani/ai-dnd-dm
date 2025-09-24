package com.aidnd.game_engine.models

import com.aidnd.game_engine.models.classes.*

interface CharacterClass {
    val name: String
    val healthDice: DiceType
    val primaryAbility: AbilityScore
    val armorProficiency: ArmorProficiency
    
    companion object {
        fun fromString(className: String): CharacterClass {
            return when (className.lowercase()) {
                "barbarian" -> Barbarian()
                "bard" -> Bard()
                "cleric" -> Cleric()
                "druid" -> Druid()
                "fighter" -> Fighter()
                "monk" -> Monk()
                "paladin" -> Paladin()
                "ranger" -> Ranger()
                "rogue" -> Rogue()
                "sorcerer" -> Sorcerer()
                "warlock" -> Warlock()
                "wizard" -> Wizard()
                else -> throw IllegalArgumentException("Unknown character class: $className")
            }
        }
    }
}
