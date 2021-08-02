import { createStore, compose, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import appReducer from './reducers/reducer';



const configureStore = () => {
   return createStore(
      appReducer,
     compose(applyMiddleware(thunk))
   );
 };
 
 export default configureStore;