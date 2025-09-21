package com.aidnd.game_engine.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["http://localhost:3000"])
class DiceController {
    
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
}