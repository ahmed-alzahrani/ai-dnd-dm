package com.aidnd.game_engine.controllers

import org.springframework.web.bind.annotation.*

import com.aidnd.game_engine.dto.DiceRollRequest
import com.aidnd.game_engine.dto.DiceRollResponse
import com.aidnd.game_engine.services.DiceService

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["http://localhost:3000"])
class DiceController(
    private val diceService: DiceService
) {
    
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello from your D&D Game Engine!"
    }
    
    @GetMapping("/roll/{sides}")
    fun rollDice(@PathVariable sides: Int): Map<String, Any> {
        val result = (1..sides).random()
        return mapOf(
            "sides" to sides,
            "result" to result,
            "message" to "Rolled a ${sides}-sided die"
        )
    }
    
    @PostMapping("/roll")
    fun rollMultipleDice(@RequestBody request: DiceRollRequest): DiceRollResponse {
        return diceService.rollDice(request)
    }
}