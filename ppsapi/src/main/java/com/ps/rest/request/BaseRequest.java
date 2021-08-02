
package com.ps.rest.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Raj
 */
public class BaseRequest implements Serializable{
    
    private String lang = "en";
    private String appid = "";
    private String action = "lookup";
    private String type;
    private Map<String, Object> param;
    private List<Map<String, Object>> params;

    public BaseRequest() {
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public List<Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(List<Map<String, Object>> params) {
        this.params = params;
    }
    
   
    
}
