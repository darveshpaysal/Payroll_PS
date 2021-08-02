package com.base.common.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Raman
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    
    

    public static SessionFactory getSessionFactory()  throws Exception{
        if (sessionFactory == null) {
          loadCfg();  
        }
        return sessionFactory;
    }
    public static void initSessionFactory()  throws Exception{
        getSessionFactory();       
    }

    private static synchronized void loadCfg() throws Exception {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
    }

    public static Session getSession()  throws Exception{
        return getSessionFactory().openSession();
    }
    
    public static Session getCurrentSession()  throws Exception{
        return getSessionFactory().getCurrentSession();
    }

    /*Close caches and connection pools*/
    public static void shutdownSource() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }
   

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
   
}
