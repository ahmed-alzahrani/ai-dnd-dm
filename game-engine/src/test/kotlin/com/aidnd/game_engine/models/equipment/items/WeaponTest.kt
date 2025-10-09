package com.aidnd.game_engine.models.equipment.items

import com.aidnd.game_engine.models.equipment.ItemBuffs
import com.aidnd.game_engine.models.equipment.enums.ItemType
import com.aidnd.game_engine.models.enums.DamageType
import com.aidnd.game_engine.models.enums.DiceType
import org.junit.jupiter.api.Test
import kotlin.test.*

class WeaponTest {

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
}
