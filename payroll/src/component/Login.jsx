import React, { Component } from "react";
import { Container,  Row, Col, Form, Button, Toast, InputGroup, Modal } from "react-bootstrap";
import history from '../router/history';
import {isBlank, stringifyJSON, log} from '../common/utils/appUtil';
import API from '../common/services/api';
import {AppConst} from '../constants/AppConstant';
import { ActionCreators } from '../store/actions/actions';
import { connect } from 'react-redux';
//import { withRouter} from "react-router-dom";
import localStore from '../common/services/localstorage';
import Loader from '../common/ui/Loader';



class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            userid : "",
            password : "",
            error : {type:'', mseg:''},
            show : false,
            showLoader :false,
            loaderMsg : '',
            pwdType : 'password',
            otp: '',
            showModal :false,
            data:{}
        }

        this.handleChange = this.handleChange.bind(this)
        this.signIn = this.signIn.bind(this)
        this.signUp = this.signUp.bind(this)
        this.showPwdEye = this.showPwdEye.bind(this);
        this.checkOTP = this.checkOTP.bind(this);
        this.handleModelClose = this.handleModelClose.bind(this);
    }

    
    handleChange(event) {
        var name = event.target.name;
        var value = (event.target.type === "checkbox") ? event.target.checked : event.target.value;
        const eventKey = event.key;
    
        this.setState({
          [name]: value
        }, () => {
          //write code when this propertychange
        })
    }

    signIn_old() {
        let msg = this.validate();
        if (isBlank(msg)) {
            let Param = {
                userName: this.state.userid,
                password: this.state.password,
                appId: AppConst.APP_ID
            }
            //console.log("param:",this.state);
            this.loader(true,"Please wait...");
            API.post('login', Param)
                .then(res => {
                    this.loader(false,"")
                    //console.log(res);
                    //console.log(res.data);
                    if (res.data.status === "1") {
                        this.putOnStore(res.data);
                        history.push('/dashboard');
                    } else {
                        this.showMsg("Invalid !!", "User Id or Password is invalid." );
                    }
                })
                .catch(err => {
                    log("login->", err);
                    this.loader(false,"")
                    this.showMsg("Error!", 'Network/Service issue.');
                })
        } else {
            this.showMsg("Error !!", msg );
        }
    }

    validate(){
        let msg = "";
        if(isBlank(this.state.userid)){
            msg = "Please Enter User Id";
        }
        else if(isBlank(this.state.password)){
            msg = "Please Enter Password";
        } 
        return msg;
    }

    putOnStore(user){
        let profile = {
            token : user.token,
            entityUid: '109',
            firstName: user.name,
            middleName: user.name,
            lastName: user.name,
            phone: '919191',
            email: 'email@email.com',
            country: '',
            state: '',
            address1: '',
            address2: '',
            profileImage: ''
         }
        
        this.props.dispatch(ActionCreators.login(profile));
        localStore.set('USER_INFO', stringifyJSON(profile));
        localStore.set('IS_LOGGED_IN', true);
    }

    signUp() {
        history.push('/signup')
    }

    showMsg(title, msg) {
        this.setState({
            ['error']: { type: title, mseg: msg }
        }, () => {
            this.setState({ ['show']: true });
        })
    }

    loader(flag,msg){
        this.setState({ ['loaderMsg']: msg});
        this.setState({ ['showLoader']: flag });
    }

    showPwdEye(){
        //this.setState({ ['pwdType']: this.state.pwdType === 'password' ? 'text' : 'password' });
    }

    alreadyPatient() {
        history.push('/alreadyPatient')
    }

    signIn() {
        let Param = {
            action: "fetch",
            type: "login",
            params: {
                userName: this.state.userid,
                password: this.state.password
            },
            appId: AppConst.APP_ID
        }
        //console.log('Param',Param);
        this.loader(true, "Please wait...");
        API.post('twofaclogin', Param)
            .then(res => {
                this.loader(false, "");
                if (res.data.status === "1") {
                    //console.log(res.data)
                    if ('true' === res.data.responseData[0].isTwoFactor) {
                        this.setState({ ['data']: res.data.responseData[0] });
                        this.setState({ ['showModal']: true });
                    } else {
                        this.putOnStore(res.data.responseData[0]);
                        history.push('/dashboard');
                    }
                } else {
                    this.showMsg("Invalid !!", "User Id or Password is invalid.");
                }
            })
            .catch(err => {
                console.log(err)
                this.loader(false, "");
                this.showMsg("Error!", 'Server/Network issue');
            })
    }

    handleModelClose(){
        this.setState({ ['showModal']: false});
    }

    checkOTP() {
        let Param = {
            action: "fetch",
            type: "twofaclogin",
            params: {
                otpCode: this.state.otp
            },
            token: this.state.data.token,
            appId: AppConst.APP_ID
        }
        //console.log('Param',Param);
        this.loader(true, "Authenticating...");
        API.post('twofaclogin', Param)
            .then(res => {
                this.loader(false, "");
                if (res.data.status === "1") {
                    this.putOnStore(res.data.responseData[0]);
                    history.push('/dashboard');
                } else {
                    this.showMsg("Error!!", res.data.statusMessage);
                }
            })
            .catch(err => {
                this.loader(false, "");
                this.showMsg("Error!", 'Server/Network issue');
            })
    }

    render() {
        return (
            <>
            <div className="rest-hight">
            {
            !navigator.onLine && <div class="alert alert-warning text-center" role="alert">You are in offline mode!!</div>
            }
            <br/><br/><br/><br/><br/>
            <Container>
                <Row>
                <Col md={3}></Col>
                <Col md={6}>
                <Form>
                    <Form.Group controlId="formBasicText">
                        <Form.Label>User Id</Form.Label>
                        <Form.Control type="text" placeholder="Enter User Id" name="userid" onChange={this.handleChange} />
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <InputGroup>
                        <Form.Control type={this.state.pwdType} placeholder="Password" name="password" onChange={this.handleChange}/>
                        <InputGroup.Append>
                        <InputGroup.Text></InputGroup.Text>
                        </InputGroup.Append>
                        </InputGroup>
                    </Form.Group>
                    <Form.Row>
                    <Col lg="3" className="p-1">
                    <Button variant="primary" className="btn-block"  onClick={this.signIn}>
                        Login
                    </Button>
                    </Col>
                    <Col lg="3" className="p-1">
                    <Button variant="primary" className="btn-block" onClick={this.signUp}>
                        Signup
                    </Button>
                    </Col>
                    </Form.Row>
                </Form>   
                </Col>
                <Col md={3}></Col>
                </Row>
            </Container>
                <Toast onClose={() => this.setState({ ['show']: false })} show={this.state.show} delay={5000} autohide className="tost-pos text-white bg-dark">
                    <Toast.Header className='text-white bg-primary'>
                        <strong className="mr-auto">{this.state.error.type}</strong>
                    </Toast.Header>
                    <Toast.Body>{this.state.error.mseg}</Toast.Body>
                </Toast>
            </div>
            <Loader show={this.state.showLoader} msg={this.state.loaderMsg} />
                <Modal show={this.state.showModal} onHide={this.handleModelClose} backdrop="static" keyboard={false} centered size="sm">
                    <Modal.Header closeButton>
                        <Modal.Title>OTP</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                    <Form>
                    <Form.Group controlId="formOtpText">
                        <Form.Label>From Email/Message</Form.Label>
                        <Form.Control type="text" placeholder="Enter OTP" name="otp" onChange={this.handleChange} />
                    </Form.Group>
                    </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={this.handleModelClose}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={this.checkOTP}>Submit</Button>
                    </Modal.Footer>
                </Modal>
            </>
        );
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
      /*// dispatching plain actions
      login: (user) => dispatch({ type: 'LOGIN' })
      */
      dispatch
    }
  }


export default connect(null,mapDispatchToProps)(Login);
//export default Login;
//export default connect(null,mapDispatchToProps)(withRouter(Login));
