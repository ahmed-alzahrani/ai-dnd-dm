package com.aidnd.game_engine.validation

object CharacterValidation {
    fun validateString(value: String, fieldName: String) {
        require(value.isNotBlank()) { "$fieldName cannot be blank" }
        require(value.length <= 20) { "$fieldName must be less than 20 characters" }
    }
    
    fun validateAbilityScores(vararg scores: Int) {
        scores.forEach { score ->
            require(score in 1..20) { "Ability score must be 1-20, got: $score" }
        }
    }
    
    fun validateAboveZero(value: Int, fieldName: String) {
        require(value > 0) { "$fieldName must be greater than 0, got: $value" }
    }
}