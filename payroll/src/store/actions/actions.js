import { Types } from '../../constants/actionTypes';

export const ActionCreators = {
   login: (user) => ({ type: Types.LOGIN, payload: { user } }),
   logout: () => ({ type: Types.LOGOUT, payload: {} }),

   //addProfile: (user) => ({ type: Types.ADD_USER, payload: { user } }),
 
   //updateProfile: (user) => ({ type: Types.UPDATE_USER, payload: { user } })
 }