package com.ps.rest.response;

import java.util.Map;

/**
 *
 * @author PS
 */
public class AppServiceResponse extends BaseResponse {
    private Integer count = 0;
    private Map<String, Object> value;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }
    
}
