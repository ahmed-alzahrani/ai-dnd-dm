package com.aidnd.game_engine.services

import com.aidnd.game_engine.dto.DiceRollRequest
import com.aidnd.game_engine.dto.DiceRollResponse
import com.aidnd.game_engine.models.DiceResult
import com.aidnd.game_engine.models.DiceSpec
import org.springframework.stereotype.Service

@Service
class DiceService {
    fun rollDice(request: DiceRollRequest): DiceRollResponse {
        val diceResults = request.dice.map { diceSpec ->
            val rolls = (1..diceSpec.count).map { (1..diceSpec.sides).random() }
            DiceResult(
                sides = diceSpec.sides,
                count = diceSpec.count,
                rolls = rolls,
                total = rolls.sum()
            )
        }
        
        return DiceRollResponse(
            diceResults = diceResults,
            total = diceResults.sumOf { it.total }
        )
    }
}