package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.models.equipment.enums.*
import com.aidnd.game_engine.models.equipment.items.*
import com.aidnd.game_engine.models.enums.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class ItemsTest {

    @Test
    fun `should create weapon with required properties`() {
        val sword = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.D8,
            damageType = DamageType.SLASHING
        )

        assertEquals("Longsword", sword.name)
        assertEquals(3.0, sword.weight)
        assertEquals(15, sword.value)
        assertEquals(DiceType.D8, sword.damageDice)
        assertEquals(DamageType.SLASHING, sword.damageType)
        assertEquals(ItemType.WEAPON, sword.itemType)
        assertNull(sword.buffs)
        assertNull(sword.description)
    }

    @Test
    fun `should create weapon with buffs`() {
        val magicSword = Weapon(
            name = "Flametongue",
            weight = 3.0,
            value = 5000,
            description = "A sword wreathed in flames",
            buffs = ItemBuffs(attack = 1, damage = 2),
            damageDice = DiceType.D8,
            damageType = DamageType.FIRE
        )

        assertEquals("Flametongue", magicSword.name)
        assertEquals(1, magicSword.buffs?.attack)
        assertEquals(2, magicSword.buffs?.damage)
    }

    @Test
    fun `should create light armor with unlimited dex bonus`() {
        val leather = Armor(
            name = "Leather Armor",
            weight = 10.0,
            value = 10,
            armorType = ArmorType.LEATHER,
            proficiencyRequired = ArmorProficiency.LIGHT,
            baseAC = 11
        )

        assertEquals("Leather Armor", leather.name)
        assertEquals(ArmorType.LEATHER, leather.armorType)
        assertEquals(ArmorProficiency.LIGHT, leather.proficiencyRequired)
        assertEquals(11, leather.baseAC)
        assertNull(leather.maxDexBonus) // Unlimited for light armor
        assertFalse(leather.stealthDisadvantage)
        assertEquals(ItemType.ARMOR, leather.itemType)
    }

    @Test
    fun `should create medium armor with capped dex bonus`() {
        val scaleMail = Armor(
            name = "Scale Mail",
            weight = 45.0,
            value = 50,
            armorType = ArmorType.SCALE_MAIL,
            proficiencyRequired = ArmorProficiency.MEDIUM,
            baseAC = 14,
            maxDexBonus = 2,
            stealthDisadvantage = true
        )

        assertEquals("Scale Mail", scaleMail.name)
        assertEquals(ArmorType.SCALE_MAIL, scaleMail.armorType)
        assertEquals(ArmorProficiency.MEDIUM, scaleMail.proficiencyRequired)
        assertEquals(14, scaleMail.baseAC)
        assertEquals(2, scaleMail.maxDexBonus)
        assertTrue(scaleMail.stealthDisadvantage)
    }

    @Test
    fun `should create heavy armor with no dex bonus`() {
        val plate = Armor(
            name = "Plate Armor",
            weight = 65.0,
            value = 1500,
            armorType = ArmorType.PLATE,
            proficiencyRequired = ArmorProficiency.HEAVY,
            baseAC = 18,
            maxDexBonus = 0,
            stealthDisadvantage = true
        )

        assertEquals("Plate Armor", plate.name)
        assertEquals(ArmorType.PLATE, plate.armorType)
        assertEquals(ArmorProficiency.HEAVY, plate.proficiencyRequired)
        assertEquals(18, plate.baseAC)
        assertEquals(0, plate.maxDexBonus)
        assertTrue(plate.stealthDisadvantage)
    }

    @Test
    fun `should create shield with AC bonus`() {
        val shield = Shield(
            name = "Shield",
            weight = 6.0,
            value = 10,
            shieldType = ShieldType.SHIELD,
            armorClassBonus = 2
        )

        assertEquals("Shield", shield.name)
        assertEquals(ShieldType.SHIELD, shield.shieldType)
        assertEquals(2, shield.armorClassBonus)
        assertEquals(ItemType.SHIELD, shield.itemType)
    }

    @Test
    fun `should create buckler with lower AC bonus`() {
        val buckler = Shield(
            name = "Buckler",
            weight = 2.0,
            value = 5,
            shieldType = ShieldType.BUCKLER,
            armorClassBonus = 1
        )

        assertEquals("Buckler", buckler.name)
        assertEquals(ShieldType.BUCKLER, buckler.shieldType)
        assertEquals(1, buckler.armorClassBonus)
    }

    @Test
    fun `should create accessory with no buffs`() {
        val cloak = Accessory(
            name = "Cloak",
            weight = 1.0,
            value = 5
        )

        assertEquals("Cloak", cloak.name)
        assertEquals(ItemType.ACCESSORY, cloak.itemType)
        assertNull(cloak.buffs)
    }

    @Test
    fun `should create accessory with AC buff`() {
        val ring = Accessory(
            name = "Ring of Protection",
            weight = 0.1,
            value = 5000,
            buffs = ItemBuffs(ac = 1)
        )

        assertEquals("Ring of Protection", ring.name)
        assertEquals(1, ring.buffs?.ac)
    }

    @Test
    fun `should create accessory with ability score buff`() {
        val belt = Accessory(
            name = "Belt of Hill Giant Strength",
            weight = 1.0,
            value = 8000,
            buffs = ItemBuffs(str = 4)
        )

        assertEquals("Belt of Hill Giant Strength", belt.name)
        assertEquals(4, belt.buffs?.str)
    }

    @Test
    fun `should create accessory with multiple buffs`() {
        val magicRing = Accessory(
            name = "Ring of Power",
            weight = 0.1,
            value = 10000,
            buffs = ItemBuffs(ac = 1, str = 2, dex = 1)
        )

        assertEquals(1, magicRing.buffs?.ac)
        assertEquals(2, magicRing.buffs?.str)
        assertEquals(1, magicRing.buffs?.dex)
    }
}
