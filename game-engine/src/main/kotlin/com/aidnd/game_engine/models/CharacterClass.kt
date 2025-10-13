package com.aidnd.game_engine.models

import com.aidnd.game_engine.models.classes.*
import com.aidnd.game_engine.models.enums.*
import com.aidnd.game_engine.models.equipment.enums.WeaponType

interface CharacterClass {
    val name: String
    val healthDice: DiceType
    val primaryAbility: AbilityScore
    val armorProficiency: ArmorProficiency
    val weaponProficiencies: Set<WeaponProficiency>
    val specificWeaponProficiencies: Set<WeaponType> get() = emptySet()
    
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
