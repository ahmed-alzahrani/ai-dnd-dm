import { useState } from 'react'

interface DiceSpec {
  sides: number
  count: number
}

interface DiceResult {
  sides: number
  count: number
  rolls: number[]
  total: number
}

interface DiceRollResponse {
  diceResults: DiceResult[]
  total: number
}

export default function DiceRoller() {
  const [message, setMessage] = useState<string>('')
  const [loading, setLoading] = useState<boolean>(false)
  const [diceRolls, setDiceRolls] = useState<DiceRollResponse | null>(null)
  const [diceInput, setDiceInput] = useState<DiceSpec[]>([
    { sides: 6, count: 1 }
  ])

  const fetchHello = async () => {
    setLoading(true)
    try {
      const response = await fetch('http://localhost:8080/api/hello')
      const text = await response.text()
      setMessage(text)
    } catch (error) {
      setMessage('Error connecting to backend: ' + error)
    } finally {
      setLoading(false)
    }
  }

  const rollDice = async () => {
    setLoading(true)
    setMessage('')
    try {
      const response = await fetch('http://localhost:8080/api/roll', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ dice: diceInput }),
      })
      
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }
      
      const result: DiceRollResponse = await response.json()
      console.log('Received response:', result)
      setDiceRolls(result)
    } catch (error) {
      setMessage('Error rolling dice: ' + error)
      console.error('Dice roll error:', error)
    } finally {
      setLoading(false)
    }
  }

  const addDice = () => {
    setDiceInput([...diceInput, { sides: 6, count: 1 }])
  }

  const removeDice = (index: number) => {
    setDiceInput(diceInput.filter((_, i) => i !== index))
  }

  const updateDice = (index: number, field: 'sides' | 'count', value: number) => {
    const updated = [...diceInput]
    updated[index] = { ...updated[index], [field]: value }
    setDiceInput(updated)
  }

  return (
    <div className="app">
      <h1>🎲 D&D Game Engine</h1>
      
      <div className="card">
        <button onClick={fetchHello} disabled={loading}>
          {loading ? 'Loading...' : 'Test API Connection'}
        </button>
        
        {message && (
          <div className="message">
            <h3>Backend Response:</h3>
            <p>{message}</p>
          </div>
        )}
      </div>

      <div className="card">
        <h2>🎲 Roll Dice</h2>
        
        <div className="dice-inputs">
          {diceInput.map((dice, index) => (
            <div key={index} className="dice-row">
              <label>
                Sides:
                <select 
                  value={dice.sides} 
                  onChange={(e) => updateDice(index, 'sides', parseInt(e.target.value))}
                >
                  <option value={3}>d3</option>
                  <option value={4}>d4</option>
                  <option value={6}>d6</option>
                  <option value={8}>d8</option>
                  <option value={10}>d10</option>
                  <option value={12}>d12</option>
                  <option value={20}>d20</option>
                  <option value={100}>d100</option>
                </select>
              </label>
              
              <label>
                Count:
                <input 
                  type="number" 
                  min="1" 
                  value={dice.count} 
                  onChange={(e) => updateDice(index, 'count', parseInt(e.target.value) || 1)}
                />
              </label>
              
              {diceInput.length > 1 && (
                <button onClick={() => removeDice(index)} className="remove-btn">
                  Remove
                </button>
              )}
            </div>
          ))}
        </div>
        
        <div className="dice-actions">
          <button onClick={addDice} className="add-btn">
            + Add More Dice
          </button>
          <button onClick={rollDice} disabled={loading} className="roll-btn">
            {loading ? 'Rolling...' : '🎲 Roll Dice'}
          </button>
        </div>
        
        {diceRolls && (
          <div className="dice-results">
            <h3>Results:</h3>
            {diceRolls.diceResults.map((result, index) => (
              <div key={index} className="result-row">
                <strong>{result.count}d{result.sides}:</strong> 
                <span className="rolls">[{result.rolls.join(', ')}]</span>
                <span className="total">= {result.total}</span>
              </div>
            ))}
            <div className="grand-total">
              <strong>Total: {diceRolls.total}</strong>
            </div>
          </div>
        )}
      </div>
      
      <p className="read-the-docs">
        Your React frontend is now connected to your Spring Boot backend!
      </p>
    </div>
  )
}
