import { useState } from 'react'
import './CharacterManager.css'

interface Character {
  id: number
  name: string
  level: number
  race: string
  characterClass: string
  maxHealth: number
  currentHealth: number
  strength: number
  dexterity: number
  constitution: number
  intelligence: number
  wisdom: number
  charisma: number
  armorClass: number
}

export default function CharacterManager() {
  const [characters, setCharacters] = useState<Character[]>([])
  const [loading, setLoading] = useState<boolean>(false)
  const [showCreateForm, setShowCreateForm] = useState<boolean>(false)
  const [nextId, setNextId] = useState<number>(1)

  const fetchParty = async () => {
    setLoading(true)
    try {
      const response = await fetch('http://localhost:8080/api/characters')
      if (response.ok) {
        const party = await response.json()
        setCharacters(party)
      }
    } catch (error) {
      console.error('Error fetching party:', error)
    } finally {
      setLoading(false)
    }
  }

  const createCharacter = async (characterData: Omit<Character, 'currentHealth' | 'maxHealth' | 'armorClass'>) => {
    setLoading(true)
    try {
      const response = await fetch('http://localhost:8080/api/characters', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(characterData),
      })
      
      if (response.ok) {
        const newCharacter = await response.json()
        setCharacters([...characters, newCharacter])
        setNextId(prev => prev + 1)
        setShowCreateForm(false)
      }
    } catch (error) {
      console.error('Error creating character:', error)
    } finally {
      setLoading(false)
    }
  }

  const deleteCharacter = async (id: number) => {
    setLoading(true)
    try {
      const response = await fetch(`http://localhost:8080/api/characters/${id}`, {
        method: 'DELETE',
      })
      
      if (response.ok) {
        setCharacters(characters.filter(char => char.id !== id))
      }
    } catch (error) {
      console.error('Error deleting character:', error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="app">
      <h1>⚔️ Character Manager</h1>
      
      <div className="card">
        <div className="party-actions">
          <button onClick={fetchParty} disabled={loading}>
            {loading ? 'Loading...' : '🔄 Refresh Party'}
          </button>
          <button onClick={() => setShowCreateForm(true)}>
            ➕ Create Character
          </button>
        </div>
        
        {characters.length === 0 ? (
          <p>No characters in party yet. Create your first character!</p>
        ) : (
          <div className="party-list">
            <h3>Your Party ({characters.length} members):</h3>
            {characters.map(character => (
              <div key={character.id} className="character-card">
                <h4>{character.name}</h4>
                <p><strong>Level {character.level} {character.race} {character.characterClass}</strong></p>
                <p>HP: {character.currentHealth}/{character.maxHealth}</p>
                <p>AC: {character.armorClass}</p>
                <div className="ability-scores">
                  <span>STR: {character.strength}</span>
                  <span>DEX: {character.dexterity}</span>
                  <span>CON: {character.constitution}</span>
                  <span>INT: {character.intelligence}</span>
                  <span>WIS: {character.wisdom}</span>
                  <span>CHA: {character.charisma}</span>
                </div>
                <button 
                  onClick={() => deleteCharacter(character.id)}
                  className="delete-btn"
                >
                  🗑️ Delete
                </button>
              </div>
            ))}
          </div>
        )}
      </div>
      
      {showCreateForm && (
        <CreateCharacterForm 
          onSubmit={createCharacter}
          onCancel={() => setShowCreateForm(false)}
          nextId={nextId}
        />
      )}
    </div>
  )
}

interface CreateCharacterFormProps {
  onSubmit: (character: Omit<Character, 'currentHealth' | 'maxHealth' | 'armorClass'>) => void
  onCancel: () => void
  nextId: number
}

function CreateCharacterForm({ onSubmit, onCancel, nextId }: CreateCharacterFormProps) {
  const [formData, setFormData] = useState({
    id: nextId,
    name: '',
    race: '',
    characterClass: '',
    strength: 8,
    dexterity: 8,
    constitution: 8,
    intelligence: 8,
    wisdom: 8,
    charisma: 8
  })

  const races = ['Human', 'Elf', 'Dwarf', 'Halfling', 'Dragonborn', 'Gnome']
  const classes = ['Barbarian', 'Bard', 'Cleric', 'Druid', 'Fighter', 'Monk', 'Paladin', 'Ranger', 'Rogue', 'Sorcerer', 'Warlock', 'Wizard']

  // Point Buy costs (8 is free, each increase costs points)
  const getPointCost = (score: number): number => {
    if (score <= 8) return 0
    if (score <= 13) return score - 8
    if (score === 14) return 7
    if (score === 15) return 9
    return 0 // Can't go above 15
  }

  const getTotalPointsSpent = (): number => {
    const abilities = ['strength', 'dexterity', 'constitution', 'intelligence', 'wisdom', 'charisma'] as const
    return abilities.reduce((total, ability) => {
      return total + getPointCost(formData[ability])
    }, 0)
  }

  const remainingPoints = 27 - getTotalPointsSpent()

  const canIncrease = (ability: keyof typeof formData): boolean => {
    return formData[ability] < 15 && remainingPoints > 0
  }

  const canDecrease = (ability: keyof typeof formData): boolean => {
    return formData[ability] > 8
  }

  const adjustAbility = (ability: keyof typeof formData, delta: number) => {
    const newValue = formData[ability] + delta
    if (newValue >= 8 && newValue <= 15) {
      setFormData(prev => ({ ...prev, [ability]: newValue }))
    }
  }

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    onSubmit(formData)
  }

  const handleChange = (field: string, value: string | number) => {
    setFormData(prev => ({ ...prev, [field]: value }))
  }

  return (
    <div className="card">
      <h3>Create New Character</h3>
      <form onSubmit={handleSubmit} className="character-form">
        <div className="form-row">
          <label>
            Name:
            <input 
              type="text" 
              value={formData.name}
              onChange={(e) => handleChange('name', e.target.value)}
              maxLength="20"
              required
            />
          </label>
          <label>
            Race:
            <select 
              value={formData.race}
              onChange={(e) => handleChange('race', e.target.value)}
              required
            >
              <option value="">Select Race</option>
              {races.map(race => (
                <option key={race} value={race}>{race}</option>
              ))}
            </select>
          </label>
        </div>
        
        <div className="form-row">
          <label>
            Class:
            <select 
              value={formData.characterClass}
              onChange={(e) => handleChange('characterClass', e.target.value)}
              required
            >
              <option value="">Select Class</option>
              {classes.map(cls => (
                <option key={cls} value={cls}>{cls}</option>
              ))}
            </select>
          </label>
        </div>
        
        <div className="point-buy-section">
          <h4>Point Buy Ability Scores</h4>
          <div className="points-remaining">
            <strong>Points Remaining: {remainingPoints}/27</strong>
            {remainingPoints < 0 && <span className="error">⚠️ Over budget!</span>}
          </div>
          
          <div className="ability-grid">
            {['strength', 'dexterity', 'constitution', 'intelligence', 'wisdom', 'charisma'].map(ability => {
              const score = formData[ability as keyof typeof formData] as number
              const modifier = Math.floor((score - 10) / 2)
              const pointsSpent = getPointCost(score)
              
              return (
                <div key={ability} className="ability-score">
                  <label>{ability.toUpperCase().substring(0, 3)}</label>
                  <div className="score-controls">
                    <button 
                      type="button"
                      onClick={() => adjustAbility(ability as keyof typeof formData, -1)}
                      disabled={!canDecrease(ability as keyof typeof formData)}
                      className="adjust-btn"
                    >
                      -
                    </button>
                    <div className="score-display">
                      <div className="score-value">{score}</div>
                      <div className="modifier">
                        {modifier >= 0 ? '+' : ''}{modifier}
                      </div>
                      <div className="points-cost">
                        {pointsSpent > 0 ? `${pointsSpent}pt${pointsSpent > 1 ? 's' : ''}` : ''}
                      </div>
                    </div>
                    <button 
                      type="button"
                      onClick={() => adjustAbility(ability as keyof typeof formData, 1)}
                      disabled={!canIncrease(ability as keyof typeof formData)}
                      className="adjust-btn"
                    >
                      +
                    </button>
                  </div>
                </div>
              )
            })}
          </div>
          
          <div className="point-buy-help">
            <small>
              <strong>Point Buy Rules:</strong> Start at 8 (0 points). 
              Scores 9-13 cost 1 point each. 
              Score 14 costs 7 points. 
              Score 15 costs 9 points. 
              Maximum 15, minimum 8.
            </small>
          </div>
        </div>
        
        <div className="form-actions">
          <button type="submit">Create Character</button>
          <button type="button" onClick={onCancel}>Cancel</button>
        </div>
      </form>
    </div>
  )
}
