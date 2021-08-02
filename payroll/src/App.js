import logo from './logo.svg';
import './App.css';
import Routes from './router/Routes';
import Header from './component/Header';

import { createStore } from 'redux'
import { Provider } from 'react-redux';
import configureStore from './store/store';

const store = configureStore();

function App() {
  return (
    <Provider store={store}>
       <Header/>
       <Routes />
    </Provider>
  );
}

export default App;
