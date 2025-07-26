import Posts from './Posts';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostPage from './PostPage';
import './menu/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import Blog from './pages/blog';



function App() {
  return (
   <Router>
      <Routes>
        <Route path='/' element={<Posts />} />
        <Route path='/post/:slug' element={<Blog />} />
      </Routes>
   </Router>
  );
  
}

export default App;
