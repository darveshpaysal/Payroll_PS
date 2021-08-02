import React, { Component } from "react";
import { Modal, Spinner } from "react-bootstrap";


class Loader extends Component {
    constructor(props) {
        super(props)
    }


    render() {
        return (
            <Modal
                show={this.props.show}
                size="sm"
                //aria-labelledby="contained-modal-title-vcenter"
                centered
            >

                <Modal.Body className="text-center">
                    <Spinner size="lg" animation="border" variant="primary" />
                    <span className="p-3">{this.props.msg}</span>
                </Modal.Body>
            </Modal>
        )
    }
}

export default Loader;