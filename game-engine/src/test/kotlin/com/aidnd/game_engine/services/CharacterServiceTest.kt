package com.aidnd.game_engine.services

import com.aidnd.game_engine.dto.CreateCharacterRequest
import com.aidnd.game_engine.dto.UpdateCharacterRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CharacterServiceTest {

    private lateinit var characterService: CharacterService

    @BeforeEach
    fun setUp() {
        characterService = CharacterService()
    }

    private fun validCreateRequest(
        id: Int = 1,
        name: String = "Mob",
        level: Int = 1,
        race: String = "Human",
        characterClass: String = "Barbarian",
        strength: Int = 16,
        dexterity: Int = 14,
        constitution: Int = 15,
        intelligence: Int = 8,
        wisdom: Int = 12,
        charisma: Int = 10
    ) = CreateCharacterRequest(
        id = id, name = name, level = level, race = race, characterClass = characterClass,
        strength = strength, dexterity = dexterity,
        constitution = constitution, intelligence = intelligence, wisdom = wisdom,
        charisma = charisma
    )

    @Test
    fun `should create character successfully`() {
        val request = validCreateRequest()
        
        val response = characterService.createCharacter(request)
        
        assertEquals(1, response.id)
        assertEquals("Mob", response.name)
        assertEquals(1, response.level)
        assertEquals("Human", response.race)
        assertEquals("Barbarian", response.characterClass)
        // Barbarian (d12) + Human Constitution bonus (15+1=16, modifier=+3) = 12 + 3 = 15 HP
        assertEquals(15, response.maxHealth)
        assertEquals(15, response.currentHealth)
        // Base AC: 10 + DEX modifier (14+1=15, modifier=+2) = 10 + 2 = 12
        assertEquals(12, response.armorClass)
    }

    @Test
    fun `should throw exception when creating character with existing ID`() {
        val request1 = validCreateRequest(id = 1)
        val request2 = validCreateRequest(id = 1, name = "Different Name")
        
        characterService.createCharacter(request1)
        
        assertThrows<CharacterAlreadyExistsException> {
            characterService.createCharacter(request2)
        }
    }

    @Test
    fun `should get character by ID`() {
        val request = validCreateRequest()
        characterService.createCharacter(request)
        
        val response = characterService.getCharacter(1)
        
        assertEquals(1, response.id)
        assertEquals("Mob", response.name)
    }

    @Test
    fun `should throw exception when getting non-existent character`() {
        assertThrows<CharacterNotFoundException> {
            characterService.getCharacter(999)
        }
    }

    @Test
    fun `should update character successfully`() {
        val createRequest = validCreateRequest()
        characterService.createCharacter(createRequest)
        
        val updateRequest = UpdateCharacterRequest(
            name = "Updated Mob",
            level = 2,
            currentHealth = 10
        )
        
        val response = characterService.updateCharacter(id = 1, request = updateRequest)
        
        assertEquals("Updated Mob", response.name)
        assertEquals(2, response.level)
        assertEquals(10, response.currentHealth)
        assertEquals(15, response.maxHealth)
    }

    @Test
    fun `should update only provided fields`() {
        val createRequest = validCreateRequest()
        characterService.createCharacter(createRequest)
        
        val updateRequest = UpdateCharacterRequest(name = "New Name")
        
        val response = characterService.updateCharacter(id = 1, request = updateRequest)
        
        assertEquals("New Name", response.name)
        assertEquals(1, response.level)
        assertEquals(15, response.maxHealth)
    }

    @Test
    fun `should throw exception when updating non-existent character`() {
        val updateRequest = UpdateCharacterRequest(name = "New Name")
        
        assertThrows<CharacterNotFoundException> {
            characterService.updateCharacter(id = 999, request = updateRequest)
        }
    }

    @Test
    fun `should delete character successfully`() {
        val request = validCreateRequest()
        characterService.createCharacter(request)
        
        val response = characterService.deleteCharacter(id = 1)
        
        assertEquals(1, response.id)
        assertEquals("Mob", response.name)
        assertEquals(0, characterService.getPartySize())
    }

    @Test
    fun `should throw exception when deleting non-existent character`() {
        assertThrows<CharacterNotFoundException> {
            characterService.deleteCharacter(999)
        }
    }

    @Test
    fun `should get empty party initially`() {
        val party = characterService.getParty()
        
        assertTrue(party.isEmpty())
        assertEquals(0, characterService.getPartySize())
    }

    @Test
    fun `should get all characters in party`() {
        val request1 = validCreateRequest(id = 1, name = "Mob")
        val request2 = validCreateRequest(id = 2, name = "Alice")
        val request3 = validCreateRequest(id = 3, name = "Bob")
        
        characterService.createCharacter(request1)
        characterService.createCharacter(request2)
        characterService.createCharacter(request3)
        
        val party = characterService.getParty()
        
        assertEquals(3, party.size)
        assertEquals(3, characterService.getPartySize())
        
        assertEquals("Mob", party[0].name)
        assertEquals("Alice", party[1].name)
        assertEquals("Bob", party[2].name)
    }

    @Test
    fun `should maintain party after character updates`() {
        val request = validCreateRequest()
        characterService.createCharacter(request)
        
        assertEquals(1, characterService.getPartySize())
        
        val updateRequest = UpdateCharacterRequest(name = "Updated Mob")
        characterService.updateCharacter(id = 1, request = updateRequest)
        
        assertEquals(1, characterService.getPartySize())
        assertEquals("Updated Mob", characterService.getCharacter(1).name)
    }

    @Test
    fun `should remove character from party after deletion`() {
        val request1 = validCreateRequest(id = 1, name = "Mob")
        val request2 = validCreateRequest(id = 2, name = "Alice")
        
        characterService.createCharacter(request1)
        characterService.createCharacter(request2)
        assertEquals(2, characterService.getPartySize())
        
        characterService.deleteCharacter(1)
        assertEquals(1, characterService.getPartySize())
        
        val party = characterService.getParty()
        assertEquals("Alice", party[0].name)
    }
}
