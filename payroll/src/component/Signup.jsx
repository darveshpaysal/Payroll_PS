import React, { Component } from "react";
import { Container, Row, Col, Form, Button, InputGroup } from "react-bootstrap";
import {isBlank} from '../common/utils/appUtil';
import API from '../common/services/api';
import {AppConst} from '../constants/AppConstant';
import history from '../router/history';
import Toastmsg from '../common/ui/Toastmsg';
import Loader from '../common/ui/Loader';


class Signup extends Component {
    constructor(props) {
        super(props)

        this.state = {
            fname :'',
            mname : '',
            lname : '',
            uname : '',
            pwd : '',
            cpwd : '',
            email : '',
            phone : '',
            addr : '',
            addr2 : '',
            city : '',
            country : '',
            state : '',
            zip : '',

            error : {type:'', mseg:''},
            show : false,
            showLoader :false,
            loaderMsg : '',

            pwdType : 'password',
            cpwdType : 'password'
        }

        this.handleChange = this.handleChange.bind(this)
        this.register = this.register.bind(this);
        this.toastClose = this.toastClose.bind(this);
        this.showPwdEye = this.showPwdEye.bind(this);
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

    register() {
        let msg = this.validate();
        if (isBlank(msg)) {
            let Param = {
                firstName: this.state.fname,
                lastName: this.state.lname,
                userName: this.state.uname,
                password: this.state.pwd,
                emailAddress: this.state.email,
                address1: this.state.addr,
                address2: this.state.addr2,
                city: this.state.city,
                state: this.state.state,
                country: this.state.country,
                postalCode: this.state.zip,
                phoneNo: this.state.phone,
                isUpdate: false,
                appId: AppConst.APP_ID
            }
            //console.log("param:", Param);
            this.loader(true,"Please wait...");
            API.post('signup', Param)
                .then(res => {
                    this.loader(false,"");
                    //console.log(res.data);
                    if (res.data.status === "1") {
                        this.showMsg("Info !!", "Signup Successfull.");
                        history.push('/login');
                    } else {
                        this.showMsg("Error !!", res.data.statusMessage);
                    }
                })
                .catch(err => { console.log(err); this.loader(false,"");})
        } else {
            this.showMsg("Error !!", msg);
        }
    }

    validate(){
        let msg = "";
        if(isBlank(this.state.fname)){
            msg = "Please Enter First Name";
        }
        else if(isBlank(this.state.lname)){
            msg = "Please Enter Last Name";
        } 
        else if(isBlank(this.state.uname)){
            msg = "Please Enter User Name";
        } 
        else if(isBlank(this.state.pwd)){
            msg = "Please Enter Password";
        } 
        else if(isBlank(this.state.cpwd)){
            msg = "Please Enter Confirm Password";
        } 
        else if(this.state.pwd !== this.state.cpwd){
            msg = "Password and Confirm password must be same";
        }
        else if(isBlank(this.state.email)){
            msg = "Please Enter email";
        }  
        else if(isBlank(this.state.phone)){
            msg = "Please Enter Phone";
        } 
        else if(isBlank(this.state.country)){
            msg = "Please Select Country";
        } 
        else if(isBlank(this.state.state)){
            msg = "Please Select State";
        }
        else if(isBlank(this.state.addr)){
            msg = "Please Enter Address";
        } 
        return msg;
    }

    showMsg(title, msg) {
        this.setState({
            ['error']: { type: title, mseg: msg }
        }, () => {
            this.setState({ ['show']: true });
        })
    }

    toastClose(){
        this.setState({ ['show']: false });
    }

    loader(flag,msg){
        this.setState({ ['loaderMsg']: msg});
        this.setState({ ['showLoader']: flag });
    }

    showPwdEye(field){
        if( field === 'pwd'){
            //this.setState({ ['pwdType']: this.state.pwdType === 'password' ? 'text' : 'password' });
        } else {
            //this.setState({ ['cpwdType']: this.state.cpwdType === 'password' ? 'text' : 'password' });
        }
    }

    render() {
        return (
            <>
            {
            !navigator.onLine && <div class="alert alert-warning text-center" role="alert">You are in offline mode!!</div>
            }
            <Container className="mt-5">
                <Form>
                    <Form.Row>
                        <Col lg="4">
                            <Form.Group controlId="fname">
                                <Form.Label>First Name:</Form.Label>
                                <Form.Control type="text" placeholder="Enter First Name" name="fname" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="4">
                            <Form.Group controlId="mname">
                                <Form.Label>Middle Name:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Middle Name" name="mname" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="4">
                            <Form.Group controlId="lname">
                                <Form.Label>Last Name:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Last Name" name="lname" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                    </Form.Row>
                    <Form.Row>
                        <Col lg="4">
                            <Form.Group controlId="uname">
                                <Form.Label>User Id:</Form.Label>
                                <Form.Control type="text" placeholder="Enter User Name" name="uname" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="4">
                                <Form.Group controlId="pwd">
                                    <Form.Label>Password:</Form.Label>
                                    <InputGroup>
                                        <Form.Control type={this.state.pwdType} placeholder="Enter Password" name="pwd" onChange={this.handleChange} />
                                        <InputGroup.Append>
                                            <InputGroup.Text></InputGroup.Text>
                                        </InputGroup.Append>
                                    </InputGroup>
                                </Form.Group>
                        </Col>
                        <Col lg="4">
                            <Form.Group controlId="cpwd">
                                    <Form.Label>Confirm Password:</Form.Label>
                                    <InputGroup>
                                        <Form.Control type={this.state.cpwdType} placeholder="Enter Confirm Password" name="cpwd" onChange={this.handleChange} />
                                        <InputGroup.Append>
                                            <InputGroup.Text></InputGroup.Text>
                                        </InputGroup.Append>
                                    </InputGroup>
                                </Form.Group>
                        </Col>
                    </Form.Row>
                    <Form.Row>
                        <Col lg="6">
                            <Form.Group controlId="email">
                                <Form.Label>Email:</Form.Label>
                                <Form.Control type="email" placeholder="Enter Email" name="email" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="6">
                            <Form.Group controlId="phone">
                                <Form.Label>Phone:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Phone" name="phone" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                    </Form.Row>
                    <Form.Row>
                        <Col lg="6">
                            <Form.Group controlId="addr">
                                <Form.Label>Address:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Address" name="addr" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="6">
                            <Form.Group controlId="addr2">
                                <Form.Label>Address2:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Address2" name="addr2" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                    </Form.Row>
                    <Form.Row>
                        <Col lg="6">
                            <Form.Group controlId="city">
                                <Form.Label>City:</Form.Label>
                                <Form.Control type="text" placeholder="Enter City" name="city" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                        <Col lg="6">
                            <Form.Group controlId="country">
                                <Form.Label>Country:</Form.Label>
                                <Form.Control as="select"  name="country" onChange={this.handleChange}>
                                <option value=''>---select one---</option>
                                    <option value='US'>USA</option>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                    </Form.Row>
                    <Form.Row>
                        <Col lg="6">
                            <Form.Group controlId="state">
                                <Form.Label>State:</Form.Label>
                                <Form.Control as="select" name="state" onChange={this.handleChange}>
                                 <option value=''>---select one---</option>
                                    <option value='CA'>California</option>
                                    <option value='GA'>GA</option>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col lg="6">
                            <Form.Group controlId="zip">
                                <Form.Label>Zip:</Form.Label>
                                <Form.Control type="text" placeholder="Enter Zip" name="zip" onChange={this.handleChange}/>
                            </Form.Group>
                        </Col>
                    </Form.Row>
                    

                    <Button variant="primary" onClick={this.register}>
                        Signup
                    </Button>
                    
                </Form>
                <Toastmsg show={this.state.show} type={this.state.error.type} msg={this.state.error.mseg} toastClose={this.toastClose} ></Toastmsg>
                <br/><br/>
            </Container>
            <Loader show={this.state.showLoader} msg={this.state.loaderMsg} />
            </>
        );
    }
}
export default Signup;