package com.base.common.query;

import com.base.common.util.MyLogger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PS
 */
public class BaseQuery implements Serializable {

    protected static MyLogger logger = new MyLogger(BaseQuery.class);
    private static Map<String, String> queryMap = new HashMap<>();

    public static final String CODE_REF_TYPE_QUERY = "CODE_REF_TYPE_QUERY";    
    
    static {
        queryMap.put(CODE_REF_TYPE_QUERY, "SELECT CODE, DESCRIPTION FROM CODE_REFERENCE WHERE TYPE = :1 ORDER BY SEQ ");
        }

    private BaseQuery() {
    }

    public static String getCustomQuery(String queryName) {
        return queryMap.get(queryName);
    }

   
}
