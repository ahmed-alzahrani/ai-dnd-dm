import { Routes, Route, Link } from 'react-router-dom'
import './App.css'
import DiceRoller from './components/DiceRoller'
import CharacterManager from './components/CharacterManager'

function App() {
  return (
    <div className="app">
      <nav className="navigation">
        <Link to="/" className="nav-link">🎲 Dice Roller</Link>
        <Link to="/characters" className="nav-link">⚔️ Characters</Link>
      </nav>
      
      <Routes>
        <Route path="/" element={<DiceRoller />} />
        <Route path="/characters" element={<CharacterManager />} />
        <Route path="*" element={<div>404 - Page Not Found</div>} />
      </Routes>
    </div>
  )
}

export default App
