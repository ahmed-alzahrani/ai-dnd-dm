package com.aidnd.game_engine.models

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CharacterTest {

    private fun validCharacter(
        id: Int = 1,
        name: String = "Mob",
        level: Int = 5,
        race: String = "Human",
        characterClass: String = "Barbarian",
        maxHealth: Int = 45,
        strength: Int = 16,
        dexterity: Int = 14,
        constitution: Int = 15,
        intelligence: Int = 8,
        wisdom: Int = 12,
        charisma: Int = 10,
        armorClass: Int = 13
    ) = Character(
        id = id, name = name, level = level, race = race, characterClass = characterClass,
        maxHealth = maxHealth, strength = strength, dexterity = dexterity,
        constitution = constitution, intelligence = intelligence, wisdom = wisdom,
        charisma = charisma, armorClass = armorClass
    )

    @Test
    fun `should create valid character with all valid values`() {
        val character = validCharacter()
        
        assertEquals("Mob", character.name)
        assertEquals(5, character.level)
        assertEquals("Human", character.race)
        assertEquals("Barbarian", character.characterClass)
        assertEquals(45, character.maxHealth)
        assertEquals(45, character.currentHealth)
        assertEquals(16, character.strength)
        assertEquals(13, character.armorClass)
    }

    @Test
    fun `should set currentHealth to maxHealth by default`() {
        val character = validCharacter(maxHealth = 100)
        assertEquals(100, character.currentHealth)
    }

    @Test
    fun `should use default level of 1 when not specified`() {
        val character = Character(
            id = 1, name = "Test", race = "Human", characterClass = "Fighter",
            maxHealth = 50, strength = 10, dexterity = 10, constitution = 10,
            intelligence = 10, wisdom = 10, charisma = 10, armorClass = 10
        )
        assertEquals(1, character.level)
    }

    @Test
    fun `should throw exception when validation fails`() {
        assertThrows<IllegalArgumentException> {
            validCharacter(name = "") // This should trigger validation
        }
    }

    @Test
    fun `should convert to CharacterResponse correctly`() {
        val character = validCharacter()
        val response = character.toResponse()
        
        assertEquals(character.id, response.id)
        assertEquals(character.name, response.name)
        assertEquals(character.level, response.level)
        assertEquals(character.race, response.race)
        assertEquals(character.characterClass, response.characterClass)
        assertEquals(character.maxHealth, response.maxHealth)
        assertEquals(character.currentHealth, response.currentHealth)
        assertEquals(character.strength, response.strength)
        assertEquals(character.dexterity, response.dexterity)
        assertEquals(character.constitution, response.constitution)
        assertEquals(character.intelligence, response.intelligence)
        assertEquals(character.wisdom, response.wisdom)
        assertEquals(character.charisma, response.charisma)
        assertEquals(character.armorClass, response.armorClass)
    }
}
