package com.aidnd.game_engine.services

import com.aidnd.game_engine.dto.CreateCharacterRequest
import com.aidnd.game_engine.dto.CharacterResponse
import com.aidnd.game_engine.dto.UpdateCharacterRequest
import com.aidnd.game_engine.models.Character
import com.aidnd.game_engine.models.Race
import com.aidnd.game_engine.models.CharacterClass
import org.springframework.stereotype.Service

@Service
class CharacterService {
    
    private val party = mutableMapOf<Int, Character>()
    
    fun createCharacter(request: CreateCharacterRequest): CharacterResponse {
        // Check if character with this ID already exists
        if (party.containsKey(request.id)) {
            throw CharacterAlreadyExistsException("Character with ID ${request.id} already exists")
        }
        
        val character = Character(
            id = request.id,
            name = request.name,
            level = request.level,
            race = Race.fromString(request.race),
            characterClass = CharacterClass.fromString(request.characterClass),
            strength = request.strength,
            dexterity = request.dexterity,
            constitution = request.constitution,
            intelligence = request.intelligence,
            wisdom = request.wisdom,
            charisma = request.charisma,
            armorClass = request.armorClass
        )
        
        party[request.id] = character
        return character.toResponse()
    }
    
    fun getCharacter(id: Int): CharacterResponse {
        val character = party[id] ?: throw CharacterNotFoundException("Character with ID $id not found")
        return character.toResponse()
    }
    
    fun updateCharacter(id: Int, request: UpdateCharacterRequest): CharacterResponse {
        val character = party[id] ?: throw CharacterNotFoundException("Character with ID $id not found")
        
        request.name?.let { character.name = it }
        request.level?.let { character.level = it }
        request.race?.let { character.race = Race.fromString(it) }
        request.characterClass?.let { character.characterClass = CharacterClass.fromString(it) }
        request.currentHealth?.let { character.currentHealth = it }
        request.strength?.let { character.strength = it }
        request.dexterity?.let { character.dexterity = it }
        request.constitution?.let { character.constitution = it }
        request.intelligence?.let { character.intelligence = it }
        request.wisdom?.let { character.wisdom = it }
        request.charisma?.let { character.charisma = it }
        request.armorClass?.let { character.armorClass = it }
        
        return character.toResponse()
    }
    
    fun deleteCharacter(id: Int): CharacterResponse {
        val character = party.remove(id) ?: throw CharacterNotFoundException("Character with ID $id not found")
        return character.toResponse()
    }
    
    
    fun getParty(): List<CharacterResponse> {
        return party.values.map { it.toResponse() }.sortedBy { it.id }
    }
    
    fun getPartySize(): Int {
        return party.size
    }
    
}

class CharacterNotFoundException(message: String) : RuntimeException(message)
class CharacterAlreadyExistsException(message: String) : RuntimeException(message)