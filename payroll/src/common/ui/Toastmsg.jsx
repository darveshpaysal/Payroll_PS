import React, { Component } from "react";
import { Toast } from "react-bootstrap";


class Toastmsg extends Component {
    constructor(props) {
        super(props)
        this.state = {
            show : false
        }
        this.toastClose = this.toastClose.bind(this)
    }


    componentWillReceiveProps(newProps) { 
        if(newProps.show && !this.setState.show){
           this.setState({show:true});
        }
     }


    toastClose(){
        this.props.toastClose();
        this.setState({show:false});    
    }

    render() {
        return (
            <Toast onClose={this.toastClose} show={this.state.show} delay={5000} autohide className="tost-pos text-white bg-dark">
                <Toast.Header className='text-white bg-primary'>
                    <strong className="mr-auto">{this.props.type}</strong>
                </Toast.Header>
                <Toast.Body>{this.props.msg}</Toast.Body>
            </Toast>
        )
    }
}

export default Toastmsg;