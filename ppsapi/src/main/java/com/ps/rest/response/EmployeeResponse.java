package com.ps.rest.response;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Raman
 */
public class EmployeeResponse extends BaseResponse {
    private Integer count = 0;
    private List<Map<String, Object>> value;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Map<String, Object>> getValue() {
        return value;
    }

    public void setValue(List<Map<String, Object>> value) {
        this.value = value;
    }
    
}
