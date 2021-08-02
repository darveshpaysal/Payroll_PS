package com.base.biz.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.base.biz.dao.CommonDAO;
import com.base.common.query.BaseQuery;
import com.base.common.util.AppConstants;
import com.base.common.util.AppUtil;

/**
 *
 * @author Raman
 */
public class CommonSO extends BaseSO {

    private static CommonSO so = null;

    private CommonSO() {
    }

    public static CommonSO getInstance() {
        if (so == null) {
            so = new CommonSO();
        }
        return so;
    }

    public List<Object[]> getTableValues(String tableQuery) throws Exception {
        return getValues(tableQuery, null);
    }

    public List<Object[]> getTableValuesSorted(String tableQuery) throws Exception {
        return getValues(tableQuery, null);
    }

    public List<Object[]> getQueryValues(String nativeQuery, String[] values) throws Exception {
        List<Object[]> queryParams = getQueryParam(values);
        return getValues(nativeQuery, queryParams);
    }

    public List<Object[]> getValues(String nativQueryStr, List<Object[]> queryParams) throws Exception {
        return CommonDAO.getInstance().getValues(nativQueryStr, queryParams);
    }

    public <T> List<T> getNamedQueryResults(String namedQueryName, List<Object[]> queryParams) throws Exception {
        return CommonDAO.getInstance().getNamedQueryResults(namedQueryName, queryParams);
    }

    public <T> T getFirstRecord(String namedQueryName, List<Object[]> queryParams) throws Exception {
        T vo = null;
        List<Object> records = getNamedQueryResults(namedQueryName, queryParams);
        if (records != null && records.size() > 0) {
            vo = (T) records.get(0);
        }
        return vo;
    }

    public List<Object[]> getNamedQueryValues(String namedQueryName, List<Object[]> queryParams) throws Exception {
        return CommonDAO.getInstance().getNamedQueryValues(namedQueryName, queryParams);
    }

    public Comparator<Object[]> PlanComparator
            = new Comparator<Object[]>() {
        public int compare(Object[] obj1, Object[] obj2) {
            Double rate1 = Double.parseDouble(obj1[3].toString());
            Double rate2 = Double.parseDouble(obj2[3].toString());
            return rate1.compareTo(rate2);
        }
    };

    public int getCountByNamedQuery(String namedQueryName, List<Object[]> queryParams) throws Exception {
        return CommonDAO.getInstance().getCountByNamedQuery(namedQueryName, queryParams);
    }

    private List<Object[]> getQueryParam(String[] values) {
        List<Object[]> queryParams = null;
        if (values != null) {
            queryParams = new ArrayList<>();
            Object[] params = null;
            int counter = 1;
            for (String value : values) {
                params = new Object[2];
                params[0] = String.valueOf(counter++);
                params[1] = value;
                queryParams.add(params);
            }
        }
        return queryParams;
    }

    public int getCountByNativeQuery(String nativeQuery, String[] values) throws Exception {
        List<Object[]> queryParams = getQueryParam(values);
        return CommonDAO.getInstance().getCountByNativeQuery(nativeQuery, queryParams);
    }

   public int updateByNatveQueryValues(String nativeQuery, String[] values) throws Exception {
        int rows = 0;
        List<Object[]> queryParams = getQueryParam(values);
        rows = CommonDAO.getInstance().updateByNativeQuery(nativeQuery, queryParams);
        return rows;
    }
    
    public boolean isTestUser(String entityUid) throws Exception {
        boolean isTestUser = false;
        if (!AppUtil.isBlank(entityUid)) {
            List<Object[]> params = new ArrayList<>();
            params.add(new Object[]{"entityUid", entityUid});
            int count = getCountByNamedQuery("EntityVO.checkTestUser", params);
            if (count > 0) {
                isTestUser = true;
            }
        }
        return isTestUser;
    }
    
      
   public List<String> getUserApps(String entityUid) {
        List<String> apps = new ArrayList<>();
        try {
            List<Object[]> values = getQueryValues("BaseQuery.getCustomQuery(BaseQuery.ENTITY_APPS_QUERY)", new String[]{entityUid});
            if (values != null) {
                for (Object[] value : values) {
                    apps.add((String) value[1]);
                }
            }
        } catch (Exception ex) {            
        }
        return apps;
    }
   
    public String getUserAppId(String entityUid) {
        List<String> apps = getUserApps(entityUid);
        if (apps.isEmpty()) {
            return AppConstants.Apps.HAYVER_RECOVERY.getValue();
        } else {
            return apps.get(0);
        }
    }    
    
}
