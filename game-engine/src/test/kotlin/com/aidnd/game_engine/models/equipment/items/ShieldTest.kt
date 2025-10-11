package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.enums.ItemType
import com.aidnd.game_engine.models.equipment.enums.ShieldType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ShieldTest {

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
}
