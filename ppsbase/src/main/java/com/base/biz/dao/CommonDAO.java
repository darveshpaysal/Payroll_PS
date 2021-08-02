package com.base.biz.dao;

/**
 *
 * @author Raman
 */
public class CommonDAO extends BaseDAO {

    private static CommonDAO dao = null;

    private CommonDAO() {
    }

    public static CommonDAO getInstance() {
        if (dao == null) {
            dao = new CommonDAO();
        }
        return dao;

    }    

}
