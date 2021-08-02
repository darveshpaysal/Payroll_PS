package com.base.common.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

/**
 *
 * @author PS
 */
public class AppUtil {

    private static List<String> datePatterns = new ArrayList<>();
    public static final String DEFAULT_TIMEZONE = "UTC";
    public static DecimalFormat twoDecimals = new DecimalFormat("#.##");
    public static final Short SHORT_ZERO = Short.parseShort("0");
    public static final Short SHORT_ONE = Short.parseShort("1");
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String DEFAULT_US_TIMEZONE = "America/New_York";
    public static final String BLANK_SPACE = " ";

    private AppUtil() {
    }

    private static SimpleDateFormat guidFormatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    static {
        datePatterns.add("MM/dd/yyyy");
        datePatterns.add("MM/dd/yyyy hh:mm a");
        datePatterns.add("MM/dd/yyyy hh:mm:ss a");
        datePatterns.add("MM/dd/yyyy HH:mm");
        datePatterns.add("MM/dd/yyyy HH:mm:ss");
    }
    protected static MyLogger logger = new MyLogger(AppUtil.class);

    public static boolean isBlank(String text) {
        return text == null || text.trim().equals("");
    }
     public static String getPrefValue(String highPref, String lowPref) {        
            return isBlank(highPref) ? lowPref : highPref;      
    }

    public static Timestamp getCurrentDateAndTime() {
        return new Timestamp(new Date().getTime());
    }
    
    public static Timestamp getTimestamp(Date date) {
        if(date != null){
        return new Timestamp(date.getTime());
        }else{
            return null;
        }
    }

    public static Date getDateWithoutTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getDateWithoutTime(Long dateInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateInMillis);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getDateTime(Long dateInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateInMillis);        
        return cal.getTime();
    }

    public static Date getTerminateDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 3999);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static Date getMinAllowedDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1900);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int getAgeInYears(Date birthDate) {
        int years = 0;
        if (birthDate != null) {
            Calendar birthDay = Calendar.getInstance();
            birthDay.setTimeInMillis(birthDate.getTime());
            long currentTime = System.currentTimeMillis();
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(currentTime);
            years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
            if ((birthDay.get(Calendar.MONTH) > now.get(Calendar.MONTH))
                    || (birthDay.get(Calendar.MONTH) == now.get(Calendar.MONTH) && birthDay.get(Calendar.DAY_OF_MONTH) > now
                    .get(Calendar.DAY_OF_MONTH))) {
                years--;
            }
        }
        return years;
    }

    /**
     * This method is used to clear cache
     *
     * @param className : this must be the class name with package ie.
     * cache.action.AutoSuggestAction
     * @param methodName : this must be the method name which is exist into
     * given class name ie. getRenderedPhysicians
     */
    public static void clearCache(String className, String methodName) {
        try {
            Class targetClass = Class.forName(className);
            Method decMethod = targetClass.getDeclaredMethod("getInstance");
            Method method = targetClass.getMethod(methodName);
            method.invoke(decMethod.invoke(null));
        } catch (Exception e) {
        }
    }

    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static String formatDate(Date date, String pattern) {
        String DateToStr = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            DateToStr = sdf.format(date);
        } catch (Exception e) {
        }
        return DateToStr;
    }

    public static Timestamp getCurTimeStampWithoutTime() {
        return new Timestamp(getDateWithoutTime().getTime());
    }

    public static List<String> getDatePatterns() {
        return datePatterns;
    }

    public static String convertToLink(String url, String text) {
        StringBuilder link = new StringBuilder();
        link.append("<a href=\"");
        link.append(url).append("\" target=\"_blank\">");
        link.append(text);
        link.append("</a>");
        return link.toString();
    }

    public static String createToken() {
        String randno = String.valueOf((long) (100000000000000L * Math.random()));
        // pad to 14 chars
        while (randno.length() < 14) {
            randno = "0" + randno;
        }
        String uid = guidFormatter.format(new java.util.Date()) + randno;
        String guid = new BigInteger(uid).toString(16).toUpperCase();
        if (guid.length() > 15) {
            guid = guid.substring(0, 14);
        }
        return guid;
    }

    // TODO:Remove
    /*public static Date getCurrentUtcDate() {
        TimeZone defaultTz = TimeZone.getDefault();
        Date utcDate = convertDate(getCurrentDate(), DateTimeZone.forTimeZone(defaultTz), DateTimeZone.UTC);
        return utcDate;
    } */
    private static Date convertDate(Date sourceDate, DateTimeZone sourceTimeZone, DateTimeZone resultTimeZone) {
        LocalDateTime localDateTime = new LocalDateTime(sourceDate.getTime());
        DateTime sourceDateTime = localDateTime.toDateTime(sourceTimeZone);
        DateTime resultDateTime = sourceDateTime.withZone(resultTimeZone);
        return resultDateTime.toLocalDateTime().toDateTime().toDate();
    }

    public static Date convertDate(Date sourceDate, String fromTimeZone, String toTimeZone) {
        Date retDate = sourceDate;
        if (sourceDate != null && !isBlank(fromTimeZone) && !isBlank(toTimeZone)) {
            DateTimeZone sourceTimeZone = DateTimeZone.forTimeZone(TimeZone.getTimeZone(fromTimeZone));
            DateTimeZone resultTimeZone = DateTimeZone.forTimeZone(TimeZone.getTimeZone(toTimeZone));
            retDate = convertDate(sourceDate, sourceTimeZone, resultTimeZone);
        }
        return retDate;
    }

    public static Date getUtcDtToResultTzDate(Date sourceDate, String resultTz) {
        Date tzDate = sourceDate;
        if (sourceDate != null && !isBlank(resultTz)) {
            TimeZone tZone = TimeZone.getTimeZone(resultTz);
            DateTimeZone resultTimeZone = DateTimeZone.forTimeZone(tZone);
            tzDate = convertDate(sourceDate, DateTimeZone.UTC, resultTimeZone);
        }
        return tzDate;
    }

    public static Date getUtcDtToResultTzWithoutTime(Date date, String resultTimeZone) {
        Date dateInTimeZone = date;
        if (date != null && !isBlank(resultTimeZone)) {
            try {
                dateInTimeZone = getUtcDtToResultTzDate(date, resultTimeZone);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (dateInTimeZone != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateInTimeZone);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            dateInTimeZone = cal.getTime();
        }
        return dateInTimeZone;
    }

    public static Date getDate(String resultTimeZone) {
        Date dateInTimeZone = null;
        if (!isBlank(resultTimeZone)) {
            DateTimeZone sourceTz = DateTimeZone.forTimeZone(TimeZone.getDefault());
            DateTimeZone resultTz = DateTimeZone.forTimeZone(TimeZone.getTimeZone(resultTimeZone));
            try {
                dateInTimeZone = convertDate(getCurrentDate(), sourceTz, resultTz);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return dateInTimeZone;
    }

    public static Date getDateWithoutTime(String resultTimeZone) {
        Calendar calendar = Calendar.getInstance();
        Date dateInTimeZone = null;
        if (!isBlank(resultTimeZone)) {
            try {
                dateInTimeZone = getDate(resultTimeZone);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            dateInTimeZone = calendar.getTime();
        }
        calendar.setTime(dateInTimeZone);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        dateInTimeZone = calendar.getTime();
        return dateInTimeZone;
    }

    /*
    * This is used to get Effective, Termination, From and To Date and Soberty date.
     */
    private static Date getUserUtcDateWithoutTime(String userTimeZone) {
        Date dateInTimeZone = null;
        if (!isBlank(userTimeZone)) {
            try {
                dateInTimeZone = getDateWithoutTime(userTimeZone);
                dateInTimeZone = convertDate(dateInTimeZone, userTimeZone, DEFAULT_TIMEZONE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return dateInTimeZone;
    }

    public static Calendar getUtcCalendar() {
        Calendar cal = Calendar.getInstance();
        Date utcDate = convertDate(cal.getTime(), DateTimeZone.forTimeZone(TimeZone.getDefault()), DateTimeZone.UTC);
        cal.setTime(utcDate);
        return cal;
    }

    public static Date getUtcDateWithoutTime() {
        return getDateWithoutTime(DEFAULT_TIMEZONE);
    }

    public static Date getUtcDateTime() {
        return getDate(DEFAULT_TIMEZONE);
    }

    // TODO: Reomve after timeZone data type length is changed
    public static String getTimeZoneLongId(String tzShortCode) {
        String retVal = null;
        if (!isBlank(tzShortCode)) {
            retVal = DateTimeZone.forTimeZone(TimeZone.getTimeZone(tzShortCode)).getID();
        }
        return retVal;
    }

    public static String getDefaultTz() {
        return TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT);
    }

    public static String getTimeZoneAbr(String timeZone) {
        String retVal = null;
        if (!isBlank(timeZone)) {
            retVal = TimeZone.getTimeZone(timeZone).getDisplayName(false, TimeZone.SHORT);
        }
        return retVal;
    }

    public static Date setUtcTimeInDate(Date sourceDate) {
        Calendar cal = getUtcCalendar();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int milisec = cal.get(Calendar.MILLISECOND);
        cal.setTime(sourceDate);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, sec);
        cal.set(Calendar.MILLISECOND, milisec);
        return cal.getTime();
    }

    public static Date addDaysInDate(Date date, int days) {
        Date retDate = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, days);
            retDate = cal.getTime();
        }
        return retDate;
    }
    public static Date getTodaysDateWithAddedMinute(int minutes) {
       Calendar cal = Calendar.getInstance();       
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int daysBetween(Date one, Date two) {
        long difference = (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
        return (int) Math.abs(difference);
    }

    public static int checkInPercentage(int noOfCheckins, int days) {
        int percentage = 0;
        if (days != 0) {
            percentage = (noOfCheckins * 100) / days;
        }
        return percentage;
    }

    //code to convert number in XXXXXXXXXXX1234 format
    public static String formatDataInXX(String data) {
        if (data != null && !data.equals("")) {
            int length = data.length();
            if (length > 4) {
                StringBuilder formatedCardNumber = new StringBuilder();
                for (int count = 0; count < length - 4; count++) {
                    if ('-' == data.charAt(count)) {
                        formatedCardNumber.append("-");
                    } else {
                        formatedCardNumber.append("X");
                    }
                }
                formatedCardNumber.append(data.substring(data.length() - 4));
                data = formatedCardNumber.toString();
            }
        }
        return data;
    }

    //code to convert number in ***********1234 format
    public static String formatDataInXX(String data, String mask, int show) {
        String maskWith = isBlank(mask) ? "X" : mask;
        if (!isBlank(data)) {
            int length = data.length();
            if (length > show) {
                StringBuilder formatedCardNumber = new StringBuilder();
                for (int count = 0; count < length - show; count++) {
                    if ('-' == data.charAt(count)) {
                        formatedCardNumber.append("-");
                    } else {
                        formatedCardNumber.append(maskWith);
                    }
                }
                formatedCardNumber.append(data.substring(data.length() - show));
                data = formatedCardNumber.toString();
            }
        }
        return data;
    }

    public static String formatData(String data, String obfuscatedChar, int lastDigitsLeft) {
        if (data != null && !data.equals("")) {
            if (obfuscatedChar == null || obfuscatedChar.isEmpty()) {
                obfuscatedChar = "X";
            }
            int length = data.length();
            if (length > 4) {
                StringBuilder formatedCardNumber = new StringBuilder();
                for (int count = 0; count < length - lastDigitsLeft; count++) {
                    formatedCardNumber.append(obfuscatedChar);
                }
                formatedCardNumber.append(data.substring(data.length() - lastDigitsLeft));
                data = formatedCardNumber.toString();
            }
        }
        return data;
    }

    public static void callMethod(String className, String methodName, Object... params)
            throws Exception {
        Class targetClass = Class.forName(className);
        Method method;
        Method decMethod = targetClass.getDeclaredMethod("getInstance");
        if (params == null) {
            method = targetClass.getMethod(methodName);
            method.invoke(decMethod.invoke(null));
        } else {
            method = targetClass.getMethod(methodName, new Class[]{Object[].class});
            method.invoke(decMethod.invoke(null), new Object[]{params});
        }
    }
    
    public static void callMethodByType(String className, String methodName, Object... params)
            throws Exception {
        Class targetClass = Class.forName(className);
        Method method;
        Method decMethod = targetClass.getDeclaredMethod("getInstance");
        if (params == null) {
            method = targetClass.getMethod(methodName);
            method.invoke(decMethod.invoke(null));
        } else {
            Class<?> paramTypes[] = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    paramTypes[i] = Integer.TYPE;
                } else if (params[i] instanceof String) {
                    paramTypes[i] = String.class;
                } else if (params[i] instanceof Date) {
                    paramTypes[i] = Date.class;
                }
            }
            method = targetClass.getMethod(methodName, paramTypes);
            method.invoke(decMethod.invoke(null), params);
        }
    }

    public static String encryptData(String data, String key) {
        String encData = null;
        try {
            encData = CryptoUtil.encryptValue(data, key);
        } catch (Exception e) {
            logger.debug(" Error in data Encryption " + e.getMessage());
        }
        return encData;
    }

    public static String decryptData(String data, String key) {
        if (data != null && data.length() >= 32) {
            try {
                data = CryptoUtil.decryptEncryptedValue(data, key);
            } catch (Exception e) {
                logger.debug(" Error in data Decryption " + e.getMessage());
            }
        }
        return data;
    }

    public static BigDecimal roundTwoDecimals(double d) {
        return new BigDecimal(twoDecimals.format(d));
    }
    
    public static Short getShortValue(boolean value){
        return value ? SHORT_ONE : SHORT_ZERO;
    }
	
	 public static BigDecimal getBigDecimal(Object object) {
        BigDecimal objValue = null;
        if (object != null) {
            if (object instanceof Boolean) {
                Boolean blnValue = (Boolean) object;
                objValue = new BigDecimal(blnValue ? 1 : 0);
            } else {
                objValue = new BigDecimal(object.toString());
            }
        }
        return objValue;
    }
         
    public static Date getEndOfDay(Date date) {
        Date endOfDay = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            endOfDay = cal.getTime();
        }
        return endOfDay;
    }
    
    public static Date getEndOfDayByTz(String timezone) {
        Date endOfDay = null;
        if(!isBlank(timezone)) {
            endOfDay = getEndOfDay(getDate(timezone));
        }
        return endOfDay;
    }
    
    public static int getDayofMonth(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        return now.get(Calendar.DAY_OF_MONTH);
    }
    public static int getMaxDayofMonth(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        return now.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public static int getDayofWeek(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        return now.get(Calendar.DAY_OF_WEEK);
    }
    public static Date addMonthsInDate(Date date, int months) {
        Date retDate = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, months);
            retDate = cal.getTime();
        }
        return retDate;
    }
    
    public static int getMonth(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        return now.get(Calendar.MONTH);
    }
    
    public static int randomWithRange(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int) (Math.random() * range) + (min <= max ? min : max);
    }
    
    public static String defaultValue(String s, String value) {
        if (s == null || s.length() == 0) {
            return value;
        } else {
            return s;
        }
    }

    public static String defaultValue(Object o, String value) {
        if (o == null || o.toString().length() == 0) {
            return value;
        } else {
            return o.toString();
        }
    }
}
