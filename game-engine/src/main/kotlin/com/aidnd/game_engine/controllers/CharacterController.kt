package com.aidnd.game_engine.controllers

import org.springframework.web.bind.annotation.*
import com.aidnd.game_engine.dto.CreateCharacterRequest
import com.aidnd.game_engine.dto.CharacterResponse
import com.aidnd.game_engine.dto.UpdateCharacterRequest
import com.aidnd.game_engine.services.CharacterService

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["http://localhost:3000"])
class CharacterController(
    private val characterService: CharacterService
) {

    @PostMapping("/characters")
    fun createCharacter(@RequestBody request: CreateCharacterRequest): CharacterResponse {
        return characterService.createCharacter(request)
    }

    @GetMapping("/characters/{id}")
    fun getCharacter(@PathVariable id: Int): CharacterResponse {
        return characterService.getCharacter(id)
    }

    @PutMapping("/characters/{id}")
    fun updateCharacter(@PathVariable id: Int, @RequestBody request: UpdateCharacterRequest): CharacterResponse {
        return characterService.updateCharacter(id, request)
    }

    @DeleteMapping("/characters/{id}")
    fun deleteCharacter(@PathVariable id: Int): CharacterResponse {
        return characterService.deleteCharacter(id)
    }
    
    @GetMapping("/characters")
    fun getParty(): List<CharacterResponse> {
        return characterService.getParty()
    }
}