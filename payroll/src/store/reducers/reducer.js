import { combineReducers } from 'redux'
import { Types } from '../../constants/actionTypes';
import { ActionCreators } from '../actions/actions'

const initialState = {
   profile: {
     entityUid: '',
     firstName: '',
     middleName: '',
     lastName: '',
     phone: '',
     email: '',
     country: '',
     state: '',
     address1: '',
     address2: '',
     profileImage: ''
   },

   loggedIn: false
 }

function User(state = initialState, action) {
   //console.log("user reducer",state)
   switch (action.type) {
      case Types.LOGIN:
         return {
            ...state,
            profile: action.payload.user,
            loggedIn: true
         }

      case Types.LOGOUT:
         return {
            profile: initialState.profile,
            loggedIn: initialState.loggedIn
         }

      default:
         return state
   }
}

/*function AddUser(state = [], action) {
   switch (action.type) {
      case Types.ADD_USER:
         return [
            ...state
         ]
      default:
         return state
   }
}*/

const appReducer = combineReducers({
   User //, AddUser
})
export default appReducer