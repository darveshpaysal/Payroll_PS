
package com.base.biz.dto;

import com.base.common.util.AppConstants;
import java.io.Serializable;

/**
 *
 * @author Raman
 */
public abstract class BaseDTO implements Serializable {

    protected static final long serialVersionUID = 1L;
    private Boolean isNew = true;
    private String timeZone = null;
    private String loggedUserId = null;
    private String locale = null;
    private String appId =  "pps";
    

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(String loggedUserId) {
        this.loggedUserId = loggedUserId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
