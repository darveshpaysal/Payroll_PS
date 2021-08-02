package com.ps.biz.service.rest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Raman
 */
public class EmployeeServiceSO {

    private static EmployeeServiceSO so = null;

    private static final Map<String, Object> cache = new HashMap<>();

    private EmployeeServiceSO() {
    }

    public static EmployeeServiceSO getInstance() {
        if (so == null) {
            so = new EmployeeServiceSO();
        }
        return so;
    }

    

}
