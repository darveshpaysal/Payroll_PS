import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
import { Link } from "react-router-dom";
import { Navbar, Nav } from 'react-bootstrap';
import { connect } from 'react-redux';
//import { withRouter} from "react-router-dom";
import history from '../router/history';
import { ActionCreators } from '../store/actions/actions';
import localStore from '../common/services/localstorage';
import {log, parseJSON} from '../common/utils/appUtil';

class Header extends Component {
  constructor(props) {
    super(props)
    this.state = { 
      isloggedIn : this.props.loggedIn

    }
    this.goto = this.goto.bind(this)
    this.logout = this.logout.bind(this)
  }

  componentDidMount() {
    let IS_LOGGED_IN = localStore.get('IS_LOGGED_IN');
    //log("header=>",IS_LOGGED_IN)
    if(IS_LOGGED_IN && !this.props.loggedIn){
      this.props.dispatch(ActionCreators.login(parseJSON(localStore.get('USER_INFO'))));
    }
  }

  goto(page){
      history.push(page);
      document.getElementById('toggleBtn').click();
  }

  logout(){
    this.props.dispatch(ActionCreators.logout());
    localStore.remove('IS_LOGGED_IN');
    localStore.remove('USER_INFO');
    document.getElementById('toggleBtn').click();
    history.push("../login");
    //history.push("../");
  }

  // function Header() {
  render() {
   // console.log("header", this.props.loggedIn +'-'+ navigator.onLine)
    return (
      <>
        <style type="text/css">
        {`
          .bg-indigo_blue {
          background-color: #402f8d;
          color: white;
          }
        `}
        </style>
        <Navbar bg="indigo_blue" expand="lg" variant="dark" sticky='top'>
          <Navbar.Brand>ViCare</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav"  id="toggleBtn"/>
          <Navbar.Collapse id="responsive-navbar-nav">
            {navigator.onLine ? <Nav className="mr-auto">
            {!this.props.loggedIn ? <>
            <Nav.Link  onClick={()=>{this.goto('/login')}}>Sign In</Nav.Link>
            <Nav.Link /*href="/signup"*/ onClick={()=>{this.goto('/signup')}}>Sign Up</Nav.Link>
            </> : <>
            <Nav.Link onClick={()=>{this.goto('/dashboard')}}>Dashboard</Nav.Link>
            <Nav.Link onClick={this.logout}>Logout</Nav.Link>
            </>}
            </Nav> : 
            <Nav className="mr-auto"><Nav.Link onClick={()=>{this.goto('/dashboard')}}>Dashboard</Nav.Link></Nav>
            } 
            {this.props.loggedIn && 
            <Navbar.Text>
                  Hello, <span className="text-white">{this.props.profile.firstName}!</span>
            </Navbar.Text>
            }
          </Navbar.Collapse>
        </Navbar>
      </>
    );
  }
}

const mapStateToProps = (state) => {
  //console.log("header state",state)
  return {
    profile: state.User.profile,
    loggedIn : state.User.loggedIn
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    dispatch
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Header);

//export default Header;
