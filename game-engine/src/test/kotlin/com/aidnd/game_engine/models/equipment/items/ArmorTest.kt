package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.enums.ArmorType
import com.aidnd.game_engine.models.equipment.enums.ItemType
import com.aidnd.game_engine.models.enums.ArmorProficiency
import org.junit.jupiter.api.Test
import kotlin.test.*

class ArmorTest {

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
}
