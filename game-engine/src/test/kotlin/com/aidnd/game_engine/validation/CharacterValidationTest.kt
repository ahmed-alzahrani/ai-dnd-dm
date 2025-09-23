package com.aidnd.game_engine.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CharacterValidationTest {

    // validateString tests
    @Test
    fun `validateString should pass for valid strings`() {
        CharacterValidation.validateString("ValidName", "Name")
        CharacterValidation.validateString("A", "Name")
        CharacterValidation.validateString("ExactlyTwentyChars!", "Name")
        // If we get here without throwing, the test passes
    }

    @Test
    fun `validateString should throw for blank strings`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateString("", "Name")
        }
        
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateString("   ", "Name")
        }
    }

    @Test
    fun `validateString should throw for strings exceeding 20 characters`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateString("ThisIsAVeryLongCharacterNameThatExceedsTwentyCharacters", "Name")
        }
    }

    @Test
    fun `validateString should include field name in error message`() {
        val exception = assertThrows<IllegalArgumentException> {
            CharacterValidation.validateString("", "Race")
        }
        assert(exception.message?.contains("Race") == true)
    }

    // validateAbilityScores tests
    @Test
    fun `validateAbilityScores should pass for valid scores`() {
        CharacterValidation.validateAbilityScores(1)
        CharacterValidation.validateAbilityScores(20)
        CharacterValidation.validateAbilityScores(10, 15, 8, 12, 14, 16)
        // If we get here without throwing, the test passes
    }

    @Test
    fun `validateAbilityScores should throw for scores below 1`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(0)
        }
        
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(-1)
        }
    }

    @Test
    fun `validateAbilityScores should throw for scores above 20`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(21)
        }
        
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(25)
        }
    }

    @Test
    fun `validateAbilityScores should validate all provided scores`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(10, 15, 0, 12, 14, 16)
        }
        
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAbilityScores(10, 21, 8, 12, 14, 16)
        }
    }

    // validateAboveZero tests
    @Test
    fun `validateAboveZero should pass for positive values`() {
        CharacterValidation.validateAboveZero(1, "Level")
        CharacterValidation.validateAboveZero(100, "Health")
        CharacterValidation.validateAboveZero(Int.MAX_VALUE, "Value")
    }

    @Test
    fun `validateAboveZero should throw for zero`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAboveZero(0, "Level")
        }
    }

    @Test
    fun `validateAboveZero should throw for negative values`() {
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAboveZero(-1, "Level")
        }
        
        assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAboveZero(-100, "Health")
        }
    }

    @Test
    fun `validateAboveZero should include field name in error message`() {
        val exception = assertThrows<IllegalArgumentException> {
            CharacterValidation.validateAboveZero(0, "Armor Class")
        }
        assert(exception.message?.contains("Armor Class") == true)
    }
}
