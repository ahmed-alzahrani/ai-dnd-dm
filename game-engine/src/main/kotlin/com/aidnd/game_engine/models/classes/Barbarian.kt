package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*


data class Barbarian(
    override val name: String = "Barbarian",
    override val healthDice: DiceType = DiceType.d12,
    override val primaryAbility: AbilityScore = AbilityScore.STRENGTH,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.MEDIUM,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE,
        WeaponProficiency.MARTIAL
    )
) : CharacterClass
