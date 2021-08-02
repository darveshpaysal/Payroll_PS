/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.biz.service;

import com.base.common.util.MyLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author durgesh.verma
 */
public class AppCacheSO extends BaseSO {

    protected static MyLogger logger = new MyLogger(AppCacheSO.class);
    private static AppCacheSO so = null;

    private AppCacheSO() {
    }

    public static AppCacheSO getInstance() {
        if (so == null) {
            so = new AppCacheSO();
        }
        return so;
    }

    public <T> Map<String, T> loadCache(String cacheTypeKey) {
        Map<String, T> cacheValues = null;
        switch (cacheTypeKey) {
            case "SYSTEM_MESSAGES": {
                cacheValues = (Map<String, T>) getSystemMessages();
                break;
            }
            default: {

            }
        }
        return cacheValues;
    }

    public Map<String, String> getSystemMessages() {
        Map<String, String> systemMessages = new HashMap<>();
        try {
            List<Object[]> values = CommonSO.getInstance().getNamedQueryValues("SystemMessagesVO.findAllIDAndText", null);
            if (values != null && !values.isEmpty()) {
                StringBuilder msgKey = null;
                for (Object[] object : values) {
                    msgKey = new StringBuilder(object[0].toString()).append("-").append(object[1].toString());
                    systemMessages.put(toUpper(msgKey.toString()), object[2] == null ? null : object[2].toString());
                }
            }
        } catch (Exception e) {
            logger.debug("Error in getting systemMessages" + e.getMessage());
        }
        return systemMessages;
    }

}
