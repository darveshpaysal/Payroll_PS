import React, { Component } from "react";
import { Container, Row, Col, Form, Button, Table, Tabs, Tab, Nav } from "react-bootstrap";
import { connect } from 'react-redux';
import API from '../common/services/api';
import {AppConst} from '../constants/AppConstant';
import {isBlank,log,stringifyJSON,parseJSON} from '../common/utils/appUtil';
import Loader from '../common/ui/Loader';
import localStore from '../common/services/localstorage';



class Dashboard extends Component {
    constructor(props) {
        super(props)
        this.state = {
            tabkey : 'ALL',
            tabdata : [],
            showLoader :false,
            loaderMsg : ''
        }
        
    }

    componentDidMount(){
         this.getVitalsList(null);
    }

    componentDidUpdate(prevProps) {
        if (this.props.profile.token !== prevProps.profile.token) {
            this.getVitalsList(null);
        }
    }

    loader(flag,msg){
        this.setState({ ['loaderMsg']: msg});
        this.setState({ ['showLoader']: flag });
    }

    getVitalsList(type){
        let msg = this.validate();
        if (isBlank(msg)) {
        let Param = {
            token: this.props.profile.token,
            vitalsType: type ? type === 'ALL'? '' : type : '',
            appId: AppConst.APP_ID
        }
        //log('Param',Param);
        this.loader(true,"Loading...");
        API.post('vitals', Param)
            .then(res => {
                this.loader(false,"");
                //log('vitals',res.data);
                if (res.data.status == "1") {
                   this.setState({['tabkey']:type ? type : 'ALL'});
                   this.setState({['tabdata']:res.data.vitals});
                   if(!type){//storing in cache
                    localStore.set('allHistory',stringifyJSON(res.data.vitals))
                   } 
                } else {
                    //this.showMsg("Error !!", res.data.statusMessage);
                }
            })
            .catch(err => {
                log("vitals->", err);
                this.loader(false,"");
                this.setState({['tabkey']: 'ALL'});
                this.setState({['tabdata']:parseJSON(localStore.get('allHistory'))});
                //this.showMsg("Error!", 'Network issue');
            })
        } else {}
    }

    validate(){
        let msg = "";
        if(isBlank(this.props.profile.token)){
            msg = "invalid token";
        } 
        return msg;
    }

    tableHeader() {
        return (
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Type</th>
                    <th>Result</th>
                    {this.state.tabkey === 'WGT' && <th>Variance</th>}
                </tr>
            </thead>
        )
    }

    tableData() {
        var rows = [];

         this.state.tabdata.map((item, index) => {
            rows.push(
            <tr key={index}>
                <td>{item.recordedDate}</td>
                <td>{item.recordedTime}</td>
                <td>{item.vitalsType}</td>
                <td>{item.result}</td>
                {this.state.tabkey === 'WGT' && <td>{item.variance}</td>}
            </tr>
            )
        })
        return <tbody>{rows}</tbody>;
    }

    tabData() {
        return (
            <Table responsive="lg" striped bordered hover>
               {this.tableHeader()}
               {this.tableData()}
            </Table>
        )
    }

    render() {
        return (
            <>
            {
            !navigator.onLine && <div class="alert alert-warning text-center" role="alert">You are in offline mode!!</div>
            }
            <Container className="mt-2">
                
            </Container>
            <Loader show={this.state.showLoader} msg={this.state.loaderMsg} />
            </>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        profile: state.User.profile,
        loggedIn: state.User.loggedIn
    }
}

export default connect(mapStateToProps)(Dashboard);
//export default Dashboard;
