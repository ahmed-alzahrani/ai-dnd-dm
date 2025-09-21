import { useState } from 'react'
import './App.css'

function App() {
  const [message, setMessage] = useState<string>('')
  const [loading, setLoading] = useState<boolean>(false)

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
      
      <p className="read-the-docs">
        Your React frontend is now connected to your Spring Boot backend!
      </p>
    </div>
  )
}

export default App
