package com.ps.biz.service.rest;

import com.ps.rest.request.BaseRequest;
import static com.ps.common.ServConstants.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Durgesh
 */
public class ParamServiceSO {

    private static ParamServiceSO so = null;

    private static Map<String, Object> cache = null;

    private ParamServiceSO() {
    }

    public static ParamServiceSO getInstance() {
        if (so == null) {
            so = new ParamServiceSO();
        }
        return so;
    }

    public Map<String, Object> getPropsReqParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        //rparam.put(ACTION_KEY, req.getAction());
        // rparam.put(TYPE_KEY, req.getType());
        Integer curPage = 1;
        try {
            if (req.getParam() != null) {
                Object value = req.getParam().get(PAGE_NO_KEY);
                if (value != null) {
                    if (value instanceof String) {
                        curPage = Integer.getInteger(value.toString());
                    } else {
                        curPage = (Integer) value;
                    }
                }
                /*if (pageNo != null) {
                
            }  */
            }
        } catch (Exception nfe) {
            nfe.printStackTrace();
        }
        rparam.put(SKIP_KEY, ((curPage - 1) * getRecordsPerPage()));
        rparam.put(TOP_KEY, getRecordsPerPage());
        rparam.put(PARAM_KEY, req.getParam());
        //rparam.put(FILTER_KEY, "lower(u.UnparsedAddress) LIKE ");
        //rparam.put(SORT_KEY, "ModificationTimestamp DESC"); 
        System.out.println(" --- getPropsReqParam - " + rparam);
        return rparam;
    }

    public Map<String, Object> getOptionsReqParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        rparam.put(PARAM_KEY, req.getParam());
        rparam.put(TOP_KEY, getQueryDocuments());
        //rparam.put(FILTER_KEY, "lower(u.UnparsedAddress) LIKE ");
        //rparam.put(SORT_KEY, "ModificationTimestamp DESC");
        System.out.println(" --- getPropsReqParam - " + rparam);
        return rparam;
    }

    public Map<String, Object> getFiltersParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        rparam.put(PARAM_KEY, req.getParam());
        // rparam.put(TOP_KEY, getQueryDocuments());
        //rparam.put(FILTER_KEY, "lower(u.UnparsedAddress) LIKE ");
        //rparam.put(SORT_KEY, "ModificationTimestamp DESC");
        System.out.println(" --- getFiltersParam - " + rparam);
        return rparam;
    }

    public Map<String, Object> getSimilarHomesReqParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        Integer priceVar = 50000;
        Integer bedsVar = 1;
        Integer bothVar = 1;
        Integer areaVar = 500;
        Integer yearBuiltVar = 5;
        Integer maxSimHomes = 20;
        if (req.getParam() != null) {
            try {
                Number price = (Number) req.getParam().get(PRICE_KEY);
                if (price != null) {
                    req.getParam().put(PRICE_MIN_KEY, (price.intValue() - priceVar));
                    req.getParam().put(PRICE_MAX_KEY, (price.intValue() + priceVar));
                }
            } catch (Exception nfe) {
                nfe.printStackTrace();
            }
            try {
                Number beds = (Number) req.getParam().get(BEDS_KEY);
                if (beds != null) {
                    req.getParam().put(BEDS_MIN_KEY, (beds.intValue() - bedsVar));
                    req.getParam().put(BEDS_MAX_KEY, (beds.intValue() + bedsVar));
                }
            } catch (Exception nfe) {
                nfe.printStackTrace();
            }
            try {
                Number baths = (Number) req.getParam().get(BATHS_KEY);
                if (baths != null) {
                    req.getParam().put(BATHS_MIN_KEY, (baths.intValue() - bothVar));
                    req.getParam().put(BATHS_MAX_KEY, (baths.intValue() + bothVar));
                }
            } catch (Exception nfe) {
                nfe.printStackTrace();
            }
            try {
                Number area = (Number) req.getParam().get(AREA_KEY);
                if (area != null) {
                    req.getParam().put(AREA_MIN_KEY, (area.intValue() - areaVar));
                    req.getParam().put(AREA_MAX_KEY, (area.intValue() + areaVar));
                }
            } catch (Exception nfe) {
                nfe.printStackTrace();
            }
            try {
                Number year = (Number) req.getParam().get(YEAR_BUILT_KEY);
                if (year != null) {
                    req.getParam().put(YEAR_BUILT_MIN_KEY, (year.intValue() - yearBuiltVar));
                    req.getParam().put(YEAR_BUILT_MAX_KEY, (year.intValue() + yearBuiltVar));
                }
            } catch (Exception nfe) {
                nfe.printStackTrace();
            }

        }
        rparam.put(SKIP_KEY, 0);
        rparam.put(TOP_KEY, maxSimHomes);
        rparam.put(PARAM_KEY, req.getParam());

        System.out.println(" --- getSimilarHomesReqParam - " + rparam);
        return rparam;
    }
    
    
    public Map<String, Object> getUserParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        rparam.put(PARAM_KEY, req.getParam());
        // rparam.put(TOP_KEY, getQueryDocuments());
        //rparam.put(FILTER_KEY, "lower(u.UnparsedAddress) LIKE ");
        //rparam.put(SORT_KEY, "ModificationTimestamp DESC");
        System.out.println(" --- getUserParam - " + rparam);
        return rparam;
    }
    public Map<String, Object> getAppParam(BaseRequest req) {
        Map<String, Object> rparam = new HashMap<>();
        rparam.put(PARAM_KEY, req.getParam());
        // rparam.put(TOP_KEY, getQueryDocuments());
        //rparam.put(FILTER_KEY, "lower(u.UnparsedAddress) LIKE ");
        //rparam.put(SORT_KEY, "ModificationTimestamp DESC");
        //System.out.println(" --- getUserParam - " + rparam);
        return rparam;
    }

    private Integer getRecordsPerPage() {
        return 50;
    }

    private Integer getQueryDocuments() {
        return 5;
    }
  
}
