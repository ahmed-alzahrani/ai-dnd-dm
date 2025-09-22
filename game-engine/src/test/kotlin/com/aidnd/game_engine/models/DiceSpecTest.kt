package com.aidnd.game_engine.models

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DiceSpecTest {

    @Test
    fun `should create valid dice spec with standard dice`() {
        DiceType.values().forEach { diceType ->
            val diceSpec = DiceSpec(sides = diceType.sides, count = 1)
            assertEquals(diceType.sides, diceSpec.sides)
            assertEquals(1, diceSpec.count)
        }
    }

    @Test
    fun `should throw exception for invalid dice sides`() {
        val invalidSides = listOf(1, 2, 5, 7, 9, 11, 13, 99, 101)
        
        invalidSides.forEach { sides ->
            assertThrows<IllegalArgumentException> {
                DiceSpec(sides = sides, count = 1)
            }
        }
    }

    @Test
    fun `should throw exception for zero count`() {
        assertThrows<IllegalArgumentException> {
            DiceSpec(sides = 6, count = 0)
        }
    }

    @Test
    fun `should throw exception for negative count`() {
        assertThrows<IllegalArgumentException> {
            DiceSpec(sides = 6, count = -1)
        }
    }
}
