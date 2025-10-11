package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ItemType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AccessoryTest {

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
            buffs = ItemBuffs(armorClass = 1)
        )

        assertEquals("Ring of Protection", ring.name)
        assertEquals(1, ring.buffs?.armorClass)
    }

    @Test
    fun `should create accessory with ability score buff`() {
        val belt = Accessory(
            name = "Belt of Hill Giant Strength",
            weight = 1.0,
            value = 8000,
            buffs = ItemBuffs(strength = 4)
        )

        assertEquals("Belt of Hill Giant Strength", belt.name)
        assertEquals(4, belt.buffs?.strength)
    }

    @Test
    fun `should create accessory with multiple buffs`() {
        val magicRing = Accessory(
            name = "Ring of Power",
            weight = 0.1,
            value = 10000,
            buffs = ItemBuffs(armorClass = 1, strength = 2, dexterity = 1)
        )

        assertEquals(1, magicRing.buffs?.armorClass)
        assertEquals(2, magicRing.buffs?.strength)
        assertEquals(1, magicRing.buffs?.dexterity)
    }
}
