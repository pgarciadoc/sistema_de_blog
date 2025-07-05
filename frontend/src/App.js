import Posts from './Posts';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostPage from './PostPage';

function App() {
  return (
   <Router>
      <Routes>
        <Route path='/' element={<Posts />} />
        <Route path='/post/:id' element={<PostPage />} />
      </Routes>
   </Router>
  );
}

export default App;
