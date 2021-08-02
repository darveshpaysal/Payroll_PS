import React, { Component } from "react";
import { Router, Switch, Route, Redirect } from "react-router-dom";

import Login from "../component/Login";
import Signup from "../component/Signup";
import Dashboard from "../component/Dashboard";
import history from './history';
//import Header from '../component/Header';
import localStore from '../common/services/localstorage';

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    {!localStore.get('IS_LOGGED_IN') ? 
                    <Route exact path="/"><Redirect to="/login" /></Route>
                    : 
                    <Route exact path="/"><Redirect to="/dashboard" /></Route>
                    }
                    <Route path="/login" component={Login} />
                    <Route path="/signup" component={Signup} />
                    <Route path="/dashboard" component={Dashboard} />
                </Switch>
            </Router>
        )
    }
}
