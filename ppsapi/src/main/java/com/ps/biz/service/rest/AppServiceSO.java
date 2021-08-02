package com.ps.biz.service.rest;

import com.base.biz.service.BaseSO;
import com.base.biz.service.CommonSO;
import com.base.common.query.BaseQuery;
import com.ps.rest.request.BaseRequest;
import com.ps.rest.response.AppServiceResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PS
 */
public class AppServiceSO extends BaseSO{

    private static AppServiceSO so = null;

    private static final Map<String, Object> cache = new HashMap<>();

    private AppServiceSO() {
    }

    public static AppServiceSO getInstance() {
        if (so == null) {
            so = new AppServiceSO();
        }
        return so;
    }
        
    public AppServiceResponse getCodeRefValues(BaseRequest request) throws Exception {
        AppServiceResponse response = new AppServiceResponse();
        Map<String, Object> typeValue = (Map<String, Object>)cache.get(request.getType());
        if (typeValue != null) {
            response.setValue(typeValue);
        } else {
            List<Object[]> values = CommonSO.getInstance().getQueryValues(BaseQuery.getCustomQuery(BaseQuery.CODE_REF_TYPE_QUERY), new String[]{request.getType()});
            response.setValue(popCodeRefValues(values, request.getType()));
        }
        response.setStatus("1");
        return response;
    }
    public AppServiceResponse getStates(BaseRequest request) throws Exception {
        AppServiceResponse response = new AppServiceResponse();
        Map<String, Object> typeValue = (Map<String, Object>)cache.get(request.getType());
        if (typeValue != null) {
            response.setValue(typeValue);
        } else {
            List<Object[]> values = CommonSO.getInstance().getQueryValues(BaseQuery.getCustomQuery(BaseQuery.CODE_REF_TYPE_QUERY), new String[]{request.getType()});
            response.setValue(popCodeRefValues(values, request.getType()));
        }
        response.setStatus("1");
        return response;
    }

    public Map<String, Object> popCodeRefValues(List<Object[]> values, String reqType) {
        Map<String, Object> refValues = new HashMap<>();
        if (values != null && !values.isEmpty()) {
            for (Object[] value : values) {
                refValues.put((String) value[0], (String) value[1]);
            }
            cache.put(reqType, refValues);
        }
        return refValues;
    }


}
