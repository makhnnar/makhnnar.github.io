import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { NavigationBar } from './navigation/NavigationBar';
import { Home } from './home/Home';
import { Profile } from './profile/Profile';
import { PostDetail } from './posts/Post';
import { LittleProjects } from './littleProjects/LittleProjects';
const App = () => {
  /**create a read books */
  return <div className='App'>
    <BrowserRouter>
      <div className='App'>
        <NavigationBar />
      </div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/myCv" element={<Profile />} />
        <Route path="/post/:id" element={<PostDetail />} />
        <Route path="/littleProjects" element={<LittleProjects />} />
        <Route path="*" element={<h2>404 - Page Not Found</h2>} />
      </Routes>
    </BrowserRouter>
  </div>;
}

export default App;
