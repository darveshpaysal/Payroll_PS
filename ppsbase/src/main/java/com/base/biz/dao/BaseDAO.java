package com.base.biz.dao;

import java.io.Serializable;
import java.util.List;
import com.base.common.util.HibernateUtil;
import com.base.biz.entity.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Raman
 */
public abstract class BaseDAO implements Serializable {

    public static int batchSize = 20;

    public <T extends BaseEntity> T save(T vo) throws Exception {
        Session currentSession = openCurrentSession();
        currentSession.save(vo);
        return vo;
    }

    public <T extends BaseEntity> T saveAndCommit(T vo) throws Exception {
        Session currentSession = openCurrentSession();
        beginTransaction(currentSession);
        currentSession.save(vo);
        commitTransaction(currentSession);
        return vo;
    }

    public BaseEntity update(BaseEntity vo) throws Exception {
        Session currentSession = openCurrentSession();
        currentSession.update(vo);
        return vo;
    }

    public BaseEntity updateAndCommit(BaseEntity vo) throws Exception {
        Session currentSession = openCurrentSession();
        beginTransaction(currentSession);
        currentSession.update(vo);
        commitTransaction(currentSession);
        return vo;
    }

    public <T extends BaseEntity> void delete(T vo) throws Exception {
        Session currentSession = openCurrentSession();
        currentSession.delete(vo);
    }

    public <T extends BaseEntity> void deleteAndCommit(T vo) throws Exception {
        Session currentSession = openCurrentSession();
        beginTransaction(currentSession);
        currentSession.delete(vo);
        commitTransaction(currentSession);
    }

    public <T> T retrieve(Class<T> classvo, String id) throws Exception {
        T vo = null;
        Session session = null;
        try {
            session = openSession();
            vo = session.get(classvo, id);
        } finally {
            closeSession(session);
        }
        return vo;
    }

    public List<Object[]> getValues(String nativeQuery, List<Object[]> queryParams) throws Exception {
        List<Object[]> resultValues = null;
        Session session = null;
        try {
            session = openSession();
            Query query = session.createSQLQuery(nativeQuery);
            if (queryParams != null) {
                for (Object[] values : queryParams) {
                    if (values.length > 1) {
                        query = query.setParameter(values[0].toString(), values[1]);
                    }
                }
            }
            resultValues = query.list();
        } finally {
            closeSession(session);
        }
        return resultValues;
    }
    public <T> List<T> getNamedQueryResults(String namedQueryName, List<Object[]> queryParams) throws Exception {
        List<T>  resultValues = null;
        Session session = null;
        try {
            session = openSession();
            Query query = session.getNamedQuery(namedQueryName);
            if (queryParams != null) {
                for (Object[] values : queryParams) {
                    if (values.length > 1) {
                        query = query.setParameter(values[0].toString(), values[1]);
                    }
                }
            }
            resultValues = query.list();
        } finally {
            closeSession(session);
        }
        return resultValues;
    }

    protected Session openCurrentSession() throws Exception {
        return HibernateUtil.getCurrentSession();
    }

    protected Session openSession() throws Exception {
        return HibernateUtil.getSession();
    }

    protected void closeSession(Session session) throws Exception {
        HibernateUtil.closeSession(session);
    }

    protected void beginTransaction(Session session) {
        if (session != null) {
            session.beginTransaction();
        }
    }

    protected void commitTransaction(Session session) {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    public List<Object[]> getNamedQueryValues(String namedQuery, List<Object[]> queryParams) throws Exception {
        List<Object[]> resultValues = null;
        Session session = null;
        try {
            session = openSession();
            Query query = session.getNamedQuery(namedQuery);
            if (queryParams != null) {
                for (Object[] values : queryParams) {
                    if (values.length > 1) {
                        query = query.setParameter(values[0].toString(), values[1]);
                    }
                }
            }
            resultValues = query.list();
        } finally {
            closeSession(session);
        }
        return resultValues;
    }

    public void saveBatchAndCommit(List<? extends BaseEntity> vos) throws Exception {
        if (vos != null) {
            Session currentSession = openCurrentSession();
            beginTransaction(currentSession);
            int count = 0;
            for (BaseEntity vo : vos) {
                currentSession.save(vo);
                if (++count % batchSize == 0) {
                    currentSession.flush();
                    currentSession.clear();
                }
            }
            commitTransaction(currentSession);
        }
    }
    public void saveBatch(List<? extends BaseEntity> vos) throws Exception {
        if (vos != null) {
            int count = 0;
            Session currentSession = openCurrentSession();
            for (BaseEntity vo : vos) {
                currentSession.save(vo);
                if (++count % batchSize == 0) {
                    currentSession.flush();
                    currentSession.clear();
                }
            }           
        }
    }

    public void updateBatchAndCommit(List<? extends BaseEntity> vos) throws Exception {
        if (vos != null) {
            Session currentSession = openCurrentSession();
            beginTransaction(currentSession);
            int count = 0;
            for (BaseEntity vo : vos) {
                currentSession.update(vo);
                if (++count % batchSize == 0) {
                    currentSession.flush();
                    currentSession.clear();
                }
            }
            commitTransaction(currentSession);
        }
    }
    public void updateBatch(List<? extends BaseEntity> vos) throws Exception {
        if (vos != null) {
            Session currentSession = openCurrentSession();
            int count = 0;
            for (BaseEntity vo : vos) {
                currentSession.update(vo);
                if (++count % batchSize == 0) {
                    currentSession.flush();
                    currentSession.clear();
                }
            }            
        }
    }
    
     public int getCountByNamedQuery(String namedQuery, List<Object[]> queryParams) throws Exception {
        int countValue = 0;
        Session session = null;
        try {
            session = openSession();
            Query query = session.getNamedQuery(namedQuery);
            if (queryParams != null) {
                for (Object[] values : queryParams) {
                    if (values.length > 1) {
                        query = query.setParameter(values[0].toString(), values[1]);
                    }
                }
            }
            countValue = ((Number)query.list().get(0)).intValue();
        } finally {
            closeSession(session);
        }
        return countValue;
    }
     
      public int getCountByNativeQuery(String nativeQuery, List<Object[]> queryParams) throws Exception {
        int countValue = 0;
        Session session = null;
        try {
            session = openSession();
            Query query = session.createSQLQuery(nativeQuery);
            if (queryParams != null) {
                for (Object[] values : queryParams) {
                    if (values.length > 1) {
                        query = query.setParameter(values[0].toString(), values[1]);
                    }
                }
            }
            countValue = ((Number)query.list().get(0)).intValue();
        } finally {
            closeSession(session);
        }
        return countValue;
    }
      
     public int updateByNativeQuery(String nativeQuery, List<Object[]> queryParams) throws Exception {
        int rows = 0;
        Session currentSession = openCurrentSession();
        beginTransaction(currentSession);
        Query query = currentSession.createSQLQuery(nativeQuery);
        if (queryParams != null) {
            for (Object[] values : queryParams) {
                if (values.length > 1) {
                    query = query.setParameter(values[0].toString(), values[1]);
                }
            }
        }
        rows = query.executeUpdate();
        commitTransaction(currentSession);
        return rows;
    }
     
      public int updateDeleteWithoutCommit(String nativeQuery, List<Object[]> queryParams) throws Exception {
        int rows = 0;
        Session currentSession = openCurrentSession();
        Query query = currentSession.createSQLQuery(nativeQuery);
        if (queryParams != null) {
            for (Object[] values : queryParams) {
                if (values.length > 1) {
                    query = query.setParameter(values[0].toString(), values[1]);
                }
            }
        }
        rows = query.executeUpdate();
        return rows;
    }
}
