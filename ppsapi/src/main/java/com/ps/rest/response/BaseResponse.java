package com.ps.rest.response;

import java.io.Serializable;

public class BaseResponse implements Serializable{

    private String status = "0";
    private String statusMessage;
    private String sessionId;    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }    

    
}
