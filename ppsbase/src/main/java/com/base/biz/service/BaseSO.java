package com.base.biz.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import com.base.common.util.HibernateUtil;
import com.base.common.util.AppUtil;
import org.hibernate.Session;
//import com.base.common.util.GlobalResources;

/**
 *
 * @author Raman
 */
public abstract class BaseSO {

   
    public <T1 extends Object, T2 extends Object> void copyFields(T1 fromEntity, T2 toEntity) throws IllegalAccessException {
      if(fromEntity != null && toEntity != null){
        Class<? extends Object> fromCopy = fromEntity.getClass();
        Class<? extends Object> toCopy = toEntity.getClass();
        Field[] fromFields = fromCopy.getDeclaredFields();
        Field[] toFields = toCopy.getDeclaredFields();
        Object value = null;
        for (Field fromField : fromFields) {
            for (Field toField : toFields) {
                if (fromField.getName().equals(toField.getName()) && fromField.getType().equals(toField.getType())
                        && !(Modifier.isFinal(toField.getModifiers()) || Modifier.isStatic(toField.getModifiers()))) {
                    fromField.setAccessible(true);
                    toField.setAccessible(true);
                    value = fromField.get(fromEntity);
                    toField.set(toEntity, value);
                    fromField.setAccessible(false);
                    toField.setAccessible(false);
                    break;
                }
            }

        }
      }

    }
    
    public <T1 extends Object, T2 extends Object> void copyFields(T1 fromEntity, T2 toEntity, String fromTimeZone, String toTimeZone) throws IllegalAccessException {
        if (fromEntity != null && toEntity != null) {
            Class<? extends Object> fromCopy = fromEntity.getClass();
            Class<? extends Object> toCopy = toEntity.getClass();
            Field[] fromFields = fromCopy.getDeclaredFields();
            Field[] toFields = toCopy.getDeclaredFields();
             try{
                Field tzField;
                Object tzValue1;
                tzField = fromCopy.getDeclaredField("timeZone1");
                tzField.setAccessible(true);
                tzValue1 = tzField.get(fromEntity);
            if(AppUtil.DEFAULT_TIMEZONE.equalsIgnoreCase(fromTimeZone)){                 
                if(tzValue1 != null){
                  toTimeZone = tzValue1.toString();                  
                }else if(toTimeZone != null && !(Modifier.isFinal(tzField.getModifiers()) || Modifier.isStatic(tzField.getModifiers()))){
                  tzField.set(fromEntity, toTimeZone);
                }                
            }else{               
                if(fromTimeZone != null && !(Modifier.isFinal(tzField.getModifiers()) || Modifier.isStatic(tzField.getModifiers()))){
                  tzField.set(fromEntity, fromTimeZone);
                }else if(fromTimeZone == null && tzValue1 != null){
                   fromTimeZone = tzValue1.toString();
                }               
            }
            tzField.setAccessible(false);
            }catch(Exception e){ 
                //System.out.println(" error in timezone checking -"+e.getMessage());
                //e.printStackTrace();
            }
            Object value = null;
            for (Field fromField : fromFields) {
                for (Field toField : toFields) {
                    if (fromField.getName().equals(toField.getName()) && fromField.getType().equals(toField.getType())
                            && !(Modifier.isFinal(toField.getModifiers()) || Modifier.isStatic(toField.getModifiers()))) {
                        fromField.setAccessible(true);
                        toField.setAccessible(true);
                        value = fromField.get(fromEntity);
                        if (value instanceof Date && ignoreFields(fromField.getName())) {
                            Date dateValue = (Date) value;
                            value = AppUtil.convertDate(dateValue, fromTimeZone, toTimeZone);
                        }
                        toField.set(toEntity, value);
                        fromField.setAccessible(false);
                        toField.setAccessible(false);
                        break;
                    }
                }

            }
        }

    }
    
    private boolean ignoreFields(String fieldName) {
        boolean valid = true;
        if (fieldName.matches("sobrietyDate|dateOfBirth|testDate|scheduledEndDate")) {
            valid = false;
        }
        return valid;
    }
    

    protected String toUpper(String strValue) {
        if (strValue != null) {
            strValue = strValue.trim().toUpperCase();
        }
        return strValue;
    }

    protected Session openCurrentSession() throws Exception {
        return HibernateUtil.getCurrentSession();
    }    

    protected void beginTransaction(Session currentSession) {
        if (currentSession != null) {
            currentSession.beginTransaction();
        }
    }

    protected void commitTransaction(Session currentSession) {
        if (currentSession != null) {
            currentSession.getTransaction().commit();
        }
    }
    
   /* protected Connection getDefaultConnection() throws SQLException {
        return GlobalResources.getConnection(getDefaultAccount(), null);
    }

    protected void releaseDefaultConnection(Connection conn) throws SQLException {
        GlobalResources.releaseConnection(conn);
    }
    
    protected String getDefaultAccount() {
        return GlobalResources.getAppProps().getProperty("default.db.account", "OPHAVER").toUpperCase();
    }
    */
    protected String toLower(String strValue) {
        if (strValue != null) {
            strValue = strValue.trim().toLowerCase();
        }
        return strValue;
    }
    
    protected String trim(String strValue) {
        if (strValue != null) {
            strValue = strValue.trim();
        }
        return strValue;
    }
    
    protected String getSysMessageKey(String msgId, String locale) {
        String msgKey = null;
        if (!AppUtil.isBlank(msgId)) {
            msgKey = toUpper(msgId + "-" + locale);
        }
        return msgKey;
    }

}
