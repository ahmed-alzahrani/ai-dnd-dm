package com.aidnd.game_engine.models.races

import com.aidnd.game_engine.models.AbilityScore
import com.aidnd.game_engine.models.Size
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RaceTest {

    @Test
    fun `should create Human with correct attributes`() {
        val human = Human()
        
        assertEquals("Human", human.name)
        assertEquals(Size.MEDIUM, human.size)
        assertEquals(30, human.speed)
        assertEquals(0, human.darkVision)
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.STRENGTH])
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.DEXTERITY])
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.CONSTITUTION])
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.INTELLIGENCE])
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.WISDOM])
        assertEquals(1, human.abilityScoreBonuses[AbilityScore.CHARISMA])
    }

    @Test
    fun `should create Elf with correct attributes`() {
        val elf = Elf()
        
        println("Elf ability score bonuses: ${elf.abilityScoreBonuses}")
        println("Strength bonus: ${elf.abilityScoreBonuses[AbilityScore.STRENGTH]}")
        println("Dexterity bonus: ${elf.abilityScoreBonuses[AbilityScore.DEXTERITY]}")
        
        assertEquals("Elf", elf.name)
        assertEquals(Size.MEDIUM, elf.size)
        assertEquals(30, elf.speed)
        assertEquals(60, elf.darkVision)
        assertEquals(2, elf.abilityScoreBonuses[AbilityScore.DEXTERITY])
        assertEquals(null, elf.abilityScoreBonuses[AbilityScore.STRENGTH]) // No bonus = null
    }

    @Test
    fun `should create Dwarf with correct attributes`() {
        val dwarf = Dwarf()
        
        assertEquals("Dwarf", dwarf.name)
        assertEquals(Size.MEDIUM, dwarf.size)
        assertEquals(25, dwarf.speed)
        assertEquals(60, dwarf.darkVision)
        assertEquals(2, dwarf.abilityScoreBonuses[AbilityScore.CONSTITUTION])
    }

    @Test
    fun `should create Halfling with correct attributes`() {
        val halfling = Halfling()
        
        assertEquals("Halfling", halfling.name)
        assertEquals(Size.SMALL, halfling.size)
        assertEquals(25, halfling.speed)
        assertEquals(0, halfling.darkVision)
        assertEquals(2, halfling.abilityScoreBonuses[AbilityScore.DEXTERITY])
    }

    @Test
    fun `should create Dragonborn with correct attributes`() {
        val dragonborn = Dragonborn()
        
        assertEquals("Dragonborn", dragonborn.name)
        assertEquals(Size.MEDIUM, dragonborn.size)
        assertEquals(30, dragonborn.speed)
        assertEquals(0, dragonborn.darkVision)
        assertEquals(2, dragonborn.abilityScoreBonuses[AbilityScore.STRENGTH])
        assertEquals(1, dragonborn.abilityScoreBonuses[AbilityScore.CHARISMA])
    }

    @Test
    fun `should create Gnome with correct attributes`() {
        val gnome = Gnome()
        
        assertEquals("Gnome", gnome.name)
        assertEquals(Size.SMALL, gnome.size)
        assertEquals(25, gnome.speed)
        assertEquals(60, gnome.darkVision)
        assertEquals(2, gnome.abilityScoreBonuses[AbilityScore.INTELLIGENCE])
    }
}
