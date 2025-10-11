package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.models.CharacterClass
import com.aidnd.game_engine.models.classes.*
import com.aidnd.game_engine.models.equipment.enums.*
import com.aidnd.game_engine.models.equipment.items.*
import com.aidnd.game_engine.models.enums.*

object StartingEquipmentFactory {
    
    fun getEquipmentForClass(characterClass: CharacterClass): Equipment {
        return when (characterClass) {
            is Barbarian -> Equipment(
                mainHand = createGreataxe()
            )
            is Bard -> Equipment(
                mainHand = createRapier(),
                armor = createLeatherArmor()
            )
            is Cleric -> Equipment(
                mainHand = createMace(),
                offHand = createShield(),
                armor = createScaleMail()
            )
            is Druid -> Equipment(
                mainHand = createScimitar(),
                offHand = createShield(),
                armor = createLeatherArmor()
            )
            is Fighter -> Equipment(
                mainHand = createLongsword(),
                offHand = createShield(),
                armor = createChainMail()
            )
            is Monk -> Equipment(
                mainHand = createShortsword()
            )
            is Paladin -> Equipment(
                mainHand = createLongsword(),
                offHand = createShield(),
                armor = createChainMail()
            )
            is Ranger -> Equipment(
                mainHand = createShortsword(),
                armor = createScaleMail()
            )
            is Rogue -> Equipment(
                mainHand = createRapier(),
                armor = createLeatherArmor()
            )
            is Sorcerer -> Equipment(
                mainHand = createDagger()
            )
            is Warlock -> Equipment(
                mainHand = createDagger(),
                armor = createLeatherArmor()
            )
            is Wizard -> Equipment(
                mainHand = createQuarterstaff()
            )
            else -> Equipment()
        }
    }
    
    private fun createGreataxe() = Weapon(
        name = "Greataxe",
        weight = 7.0,
        value = 30,
        weaponType = WeaponType.GREATAXE,
        damageDice = DiceType.d12,
        damageType = DamageType.SLASHING
    )
    
    private fun createLongsword() = Weapon(
        name = "Longsword",
        weight = 3.0,
        value = 15,
        weaponType = WeaponType.LONGSWORD,
        damageDice = DiceType.d8,
        damageType = DamageType.SLASHING
    )
    
    private fun createShortsword() = Weapon(
        name = "Shortsword",
        weight = 2.0,
        value = 10,
        weaponType = WeaponType.SHORTSWORD,
        damageDice = DiceType.d6,
        damageType = DamageType.PIERCING
    )
    
    private fun createRapier() = Weapon(
        name = "Rapier",
        weight = 2.0,
        value = 25,
        weaponType = WeaponType.RAPIER,
        damageDice = DiceType.d8,
        damageType = DamageType.PIERCING
    )
    
    private fun createScimitar() = Weapon(
        name = "Scimitar",
        weight = 3.0,
        value = 25,
        weaponType = WeaponType.SCIMITAR,
        damageDice = DiceType.d6,
        damageType = DamageType.SLASHING
    )
    
    private fun createMace() = Weapon(
        name = "Mace",
        weight = 4.0,
        value = 5,
        weaponType = WeaponType.MACE,
        damageDice = DiceType.d6,
        damageType = DamageType.BLUDGEONING
    )
    
    private fun createQuarterstaff() = Weapon(
        name = "Quarterstaff",
        weight = 4.0,
        value = 2,
        weaponType = WeaponType.QUARTERSTAFF,
        damageDice = DiceType.d6,
        damageType = DamageType.BLUDGEONING
    )
    
    private fun createDagger() = Weapon(
        name = "Dagger",
        weight = 1.0,
        value = 2,
        weaponType = WeaponType.DAGGER,
        damageDice = DiceType.d4,
        damageType = DamageType.PIERCING
    )
    
    private fun createLeatherArmor() = Armor(
        name = "Leather Armor",
        weight = 10.0,
        value = 10,
        armorType = ArmorType.LEATHER,
        proficiencyRequired = ArmorProficiency.LIGHT,
        baseAC = 11
    )
    
    private fun createScaleMail() = Armor(
        name = "Scale Mail",
        weight = 45.0,
        value = 50,
        armorType = ArmorType.SCALE_MAIL,
        proficiencyRequired = ArmorProficiency.MEDIUM,
        baseAC = 14,
        maxDexBonus = 2,
        stealthDisadvantage = true
    )
    
    private fun createChainMail() = Armor(
        name = "Chain Mail",
        weight = 55.0,
        value = 75,
        armorType = ArmorType.CHAIN_MAIL,
        proficiencyRequired = ArmorProficiency.HEAVY,
        baseAC = 16,
        maxDexBonus = 0,
        stealthDisadvantage = true
    )
    
    private fun createShield() = Shield(
        name = "Shield",
        weight = 6.0,
        value = 10,
        shieldType = ShieldType.SHIELD,
        armorClassBonus = 2
    )
}
