import AdminInterfacePage from './pages/AdminInterfacePage';
import LoginPage from './pages/LoginPage';
import ClientInterfacePage from './pages/ClientInterfacePage';
import LandingPage from './pages/NavBar';
import { Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <LandingPage />
      <Routes>
        <Route path="/AdminInterfacePage" element={<AdminInterfacePage />} />
        <Route path="/LoginPage" element={<LoginPage />} />
        <Route path="/ClientInterfacePage" element={<ClientInterfacePage />} />
      </Routes>
    </div>
  );
}

export default App;
