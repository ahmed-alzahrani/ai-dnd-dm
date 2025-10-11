package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.models.equipment.enums.*
import com.aidnd.game_engine.models.equipment.items.*
import com.aidnd.game_engine.models.enums.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class EquipmentTest {

    @Test
    fun `should create empty equipment`() {
        val equipment = Equipment()

        assertNull(equipment.mainHand)
        assertNull(equipment.offHand)
        assertNull(equipment.armor)
        assertNull(equipment.head)
        assertEquals(12, equipment.getAllItems().size)
        assertTrue(equipment.getEquippedItems().isEmpty())
    }

    @Test
    fun `should equip weapon to main hand`() {
        val sword = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.d8,
            damageType = DamageType.SLASHING
        )
        val equipment = Equipment()

        val updated = equipment.equipItem(EquipmentSlot.MAIN_HAND, sword)

        assertNotNull(updated.mainHand)
        assertEquals("Longsword", updated.mainHand?.name)
    }

    @Test
    fun `should equip armor`() {
        val leather = Armor(
            name = "Leather Armor",
            weight = 10.0,
            value = 10,
            armorType = ArmorType.LEATHER,
            proficiencyRequired = ArmorProficiency.LIGHT,
            baseAC = 11
        )
        val equipment = Equipment()

        val updated = equipment.equipItem(EquipmentSlot.ARMOR, leather)

        assertNotNull(updated.armor)
        assertEquals("Leather Armor", updated.armor?.name)
    }

    @Test
    fun `should equip shield to off hand`() {
        val shield = Shield(
            name = "Shield",
            weight = 6.0,
            value = 10,
            shieldType = ShieldType.SHIELD,
            armorClassBonus = 2
        )
        val equipment = Equipment()

        val updated = equipment.equipItem(EquipmentSlot.OFF_HAND, shield)

        assertNotNull(updated.offHand)
        assertEquals("Shield", updated.offHand?.name)
    }

    @Test
    fun `should unequip item from slot`() {
        val sword = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.d8,
            damageType = DamageType.SLASHING
        )
        val equipment = Equipment().equipItem(EquipmentSlot.MAIN_HAND, sword)

        val updated = equipment.unequipItem(EquipmentSlot.MAIN_HAND)

        assertNull(updated.mainHand)
    }

    @Test
    fun `should get item in specific slot`() {
        val ring = Accessory(
            name = "Ring of Protection",
            weight = 0.1,
            value = 5000,
            buffs = ItemBuffs(ac = 1)
        )
        val equipment = Equipment().equipItem(EquipmentSlot.RING_LEFT, ring)

        val item = equipment.getItemInSlot(EquipmentSlot.RING_LEFT)

        assertNotNull(item)
        assertEquals("Ring of Protection", item?.name)
    }

    @Test
    fun `should get all slots including empty ones`() {
        val sword = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.d8,
            damageType = DamageType.SLASHING
        )
        val equipment = Equipment().equipItem(EquipmentSlot.MAIN_HAND, sword)

        val allItems = equipment.getAllItems()

        assertEquals(12, allItems.size)
        assertTrue(allItems.any { it.first == EquipmentSlot.MAIN_HAND && it.second?.name == "Longsword" })
        assertTrue(allItems.any { it.first == EquipmentSlot.OFF_HAND && it.second == null })
    }

    @Test
    fun `should get only equipped items without nulls`() {
        val sword = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.d8,
            damageType = DamageType.SLASHING
        )
        val shield = Shield(
            name = "Shield",
            weight = 6.0,
            value = 10,
            shieldType = ShieldType.SHIELD,
            armorClassBonus = 2
        )
        val equipment = Equipment()
            .equipItem(EquipmentSlot.MAIN_HAND, sword)
            .equipItem(EquipmentSlot.OFF_HAND, shield)

        val equippedItems = equipment.getEquippedItems()

        assertEquals(2, equippedItems.size)
        assertTrue(equippedItems.any { it.first == EquipmentSlot.MAIN_HAND && it.second.name == "Longsword" })
        assertTrue(equippedItems.any { it.first == EquipmentSlot.OFF_HAND && it.second.name == "Shield" })
    }

    @Test
    fun `should replace equipped item in slot`() {
        val sword1 = Weapon(
            name = "Shortsword",
            weight = 2.0,
            value = 10,
            damageDice = DiceType.d6,
            damageType = DamageType.PIERCING
        )
        val sword2 = Weapon(
            name = "Longsword",
            weight = 3.0,
            value = 15,
            damageDice = DiceType.d8,
            damageType = DamageType.SLASHING
        )
        val equipment = Equipment().equipItem(EquipmentSlot.MAIN_HAND, sword1)

        val updated = equipment.equipItem(EquipmentSlot.MAIN_HAND, sword2)

        assertEquals("Longsword", updated.mainHand?.name)
    }
}
