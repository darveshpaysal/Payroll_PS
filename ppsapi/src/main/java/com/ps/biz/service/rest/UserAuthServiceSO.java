package com.ps.biz.service.rest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Raman
 */
public class UserAuthServiceSO {

    private static UserAuthServiceSO so = null;

    private static final Map<String, Object> cache = new HashMap<>();

    private UserAuthServiceSO() {
    }

    public static UserAuthServiceSO getInstance() {
        if (so == null) {
            so = new UserAuthServiceSO();
        }
        return so;
    }

   
}
