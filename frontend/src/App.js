import Posts from './Posts';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostPage from './PostPage';
import './menu/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';



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
