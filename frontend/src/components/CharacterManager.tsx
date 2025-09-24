import { useState } from 'react'

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

  const createCharacter = async (characterData: Omit<Character, 'currentHealth'>) => {
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
        />
      )}
    </div>
  )
}

interface CreateCharacterFormProps {
  onSubmit: (character: Omit<Character, 'currentHealth'>) => void
  onCancel: () => void
}

function CreateCharacterForm({ onSubmit, onCancel }: CreateCharacterFormProps) {
  const [formData, setFormData] = useState({
    id: 1,
    name: '',
    level: 1,
    race: '',
    characterClass: '',
    maxHealth: 10,
    strength: 10,
    dexterity: 10,
    constitution: 10,
    intelligence: 10,
    wisdom: 10,
    charisma: 10,
    armorClass: 10
  })

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
            ID:
            <input 
              type="number" 
              value={formData.id}
              onChange={(e) => handleChange('id', parseInt(e.target.value) || 1)}
              min="1"
            />
          </label>
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
        </div>
        
        <div className="form-row">
          <label>
            Level:
            <input 
              type="number" 
              value={formData.level}
              onChange={(e) => handleChange('level', parseInt(e.target.value) || 1)}
              min="1"
            />
          </label>
          <label>
            Race:
            <input 
              type="text" 
              value={formData.race}
              onChange={(e) => handleChange('race', e.target.value)}
              maxLength="20"
              required
            />
          </label>
        </div>
        
        <div className="form-row">
          <label>
            Class:
            <input 
              type="text" 
              value={formData.characterClass}
              onChange={(e) => handleChange('characterClass', e.target.value)}
              maxLength="20"
              required
            />
          </label>
          <label>
            Max Health:
            <input 
              type="number" 
              value={formData.maxHealth}
              onChange={(e) => handleChange('maxHealth', parseInt(e.target.value) || 10)}
              min="1"
            />
          </label>
        </div>
        
        <div className="form-row">
          <label>
            Armor Class:
            <input 
              type="number" 
              value={formData.armorClass}
              onChange={(e) => handleChange('armorClass', parseInt(e.target.value) || 10)}
              min="1"
            />
          </label>
        </div>
        
        <div className="ability-scores-input">
          <h4>Ability Scores (1-20):</h4>
          <div className="ability-grid">
            {['strength', 'dexterity', 'constitution', 'intelligence', 'wisdom', 'charisma'].map(ability => (
              <label key={ability}>
                {ability.toUpperCase().substring(0, 3)}:
                <input 
                  type="number" 
                  value={formData[ability as keyof typeof formData] as number}
                  onChange={(e) => handleChange(ability, parseInt(e.target.value) || 10)}
                  min="1"
                  max="20"
                />
              </label>
            ))}
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
