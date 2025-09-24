package com.aidnd.game_engine.models

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AbilityScoreTest {

    @Test
    fun `should have correct display names`() {
        assertEquals("Strength", AbilityScore.STRENGTH.displayName)
        assertEquals("Dexterity", AbilityScore.DEXTERITY.displayName)
        assertEquals("Constitution", AbilityScore.CONSTITUTION.displayName)
        assertEquals("Intelligence", AbilityScore.INTELLIGENCE.displayName)
        assertEquals("Wisdom", AbilityScore.WISDOM.displayName)
        assertEquals("Charisma", AbilityScore.CHARISMA.displayName)
    }

    @Test
    fun `should calculate modifiers correctly`() {
        // Test various ability scores
        assertEquals(-5, AbilityScore.STRENGTH.getModifier(0))   // 0 score = -5 modifier
        assertEquals(-1, AbilityScore.STRENGTH.getModifier(8))   // 8 score = -1 modifier
        assertEquals(0, AbilityScore.STRENGTH.getModifier(10))   // 10 score = 0 modifier
        assertEquals(1, AbilityScore.STRENGTH.getModifier(12))   // 12 score = +1 modifier
        assertEquals(3, AbilityScore.STRENGTH.getModifier(16))   // 16 score = +3 modifier
        assertEquals(5, AbilityScore.STRENGTH.getModifier(20))   // 20 score = +5 modifier
    }
}
