package com.aidnd.game_engine.models.classes

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.enums.*

data class Ranger(
    override val name: String = "Ranger",
    override val healthDice: DiceType = DiceType.d10,
    override val primaryAbility: AbilityScore = AbilityScore.DEXTERITY,
    override val armorProficiency: ArmorProficiency = ArmorProficiency.MEDIUM,
    override val weaponProficiencies: Set<WeaponProficiency> = setOf(
        WeaponProficiency.SIMPLE,
        WeaponProficiency.MARTIAL
    )
) : CharacterClass
