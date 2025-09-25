package com.aidnd.game_engine.models

import com.aidnd.game_engine.models.races.Human
import com.aidnd.game_engine.models.races.Elf
import com.aidnd.game_engine.models.classes.Barbarian
import com.aidnd.game_engine.models.classes.Wizard
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CharacterTest {

        private fun validCharacter(
            id: Int = 1,
            name: String = "Mob",
            level: Int = 1,
            race: Race = Human(),
            characterClass: CharacterClass = Barbarian(),
            strength: Int = 16,
            dexterity: Int = 14,
            constitution: Int = 15,
            intelligence: Int = 8,
            wisdom: Int = 12,
            charisma: Int = 10
        ) = Character(
            id = id, name = name, level = level, race = race, characterClass = characterClass,
            strength = strength, dexterity = dexterity,
            constitution = constitution, intelligence = intelligence, wisdom = wisdom,
            charisma = charisma
        )

    @Test
    fun `should create valid character with all valid values`() {
        val character = validCharacter()
        
        assertEquals("Mob", character.name)
        assertEquals(1, character.level)
        assertEquals("Human", character.race.name)
        assertEquals("Barbarian", character.characterClass.name)
        assertEquals(15, character.maxHealth)
        assertEquals(15, character.currentHealth)
        assertEquals(16, character.strength)
        // Base AC: 10 + DEX modifier
        assertEquals(12, character.armorClass)
    }

    @Test
    fun `should set currentHealth to maxHealth by default`() {
        val character = validCharacter(constitution = 20) // +5 CON modifier
        // Barbarian (d12) + CON modifier (5) = 12 + 5 = 17 HP
        assertEquals(17, character.currentHealth)
    }

    @Test
    fun `should use default level of 1 when not specified`() {
        val character = Character(
            id = 1, name = "Test", race = Human(), characterClass = Barbarian(),
            strength = 10, dexterity = 10, constitution = 10,
            intelligence = 10, wisdom = 10, charisma = 10
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
        assertEquals(character.race.name, response.race)
        assertEquals(character.characterClass.name, response.characterClass)
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

    @Test
    fun `should apply race bonuses to ability scores`() {
        val character = validCharacter(race = Elf(), strength = 10, dexterity = 14)
        
        // Elf gets +2 Dexterity
        assertEquals(10, character.strength)  // No bonus
        assertEquals(16, character.getAbilityScore(AbilityScore.DEXTERITY))  // 14 + 2
        assertEquals(3, character.getAbilityModifier(AbilityScore.DEXTERITY))  // (16-10)/2 = 3
    }

    @Test
    fun `should apply human bonuses to all ability scores`() {
        val character = validCharacter(race = Human(), strength = 10, dexterity = 10, constitution = 10)
        
        // Human gets +1 to all abilities
        assertEquals(11, character.getAbilityScore(AbilityScore.STRENGTH))  // 10 + 1
        assertEquals(11, character.getAbilityScore(AbilityScore.DEXTERITY))  // 10 + 1
        assertEquals(11, character.getAbilityScore(AbilityScore.CONSTITUTION))  // 10 + 1
    }

    @Test
    fun `should return correct darkvision from race`() {
        val human = validCharacter(race = Human())
        val elf = validCharacter(race = Elf())
        
        assertEquals(0, human.getDarkVision())
        assertEquals(60, elf.getDarkVision())
    }

    @Test
    fun `should compute maxHealth based on character class and constitution`() {
        val barbarian = validCharacter(characterClass = Barbarian(), constitution = 16) // +3 CON modifier
        val wizard = validCharacter(characterClass = Wizard(), constitution = 8) // 0 CON modifier
        
        // Barbarian (d12) + CON modifier (3) = 12 + 3 = 15 HP
        assertEquals(15, barbarian.maxHealth)
        // Wizard (d6) + Human Constitution bonus (8+1=9, modifier=0) = 6 + 0 = 6 HP  
        assertEquals(6, wizard.maxHealth)
    }
}
