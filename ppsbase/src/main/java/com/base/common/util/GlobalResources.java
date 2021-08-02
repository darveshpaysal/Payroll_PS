package com.base.common.util;

;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Central storage point for web application resources such as Properties,
 * Connection Pools, etc.
 */


public class GlobalResources {

    private static String nl = System.getProperties().getProperty("line.separator");

    // local logger
    private static MyLogger logger = new MyLogger(GlobalResources.class);

    // flag set when init is called
    private static boolean initCalled = false;

    // application identifier
    private static String applicationId = "application";

    // Application properties
    private static Properties appProps = null;
    private static final Object appPropsLock = new Object();
    // log4j properties
    private static Properties logProps = null;
    private static final Object logPropsLock = new Object();
    private static String logFile = null;

    /**
     * private constructor to disallow instantiation
     */
    private GlobalResources() {
    }

    /**
     * This method is called when a servlet is initialized. It is used to
     * initialize any resources which may be needed by the application. If the
     * specified application id is null or empty then it defaults to
     * "application". *
     */
    public static synchronized void init() {
        if (!initCalled) {
            try {

                //Load log4j properties file
                getLogProps();

                //Load application properties file
                getAppProps();

                //Initialize Hibernate  session factory
                HibernateUtil.initSessionFactory();

                //Initialize Application Cache
                CacheUtil.initCache();

                //Initialize Job Scheduler
               // initScheduler();

                initCalled = true;
            } catch (Exception ex) {
                logger.error(">>>>>>>>>>>>>>>>>>>>  Failed to initialize application = ", ex);
            }
        }
    }

    /**
     * Get main application properties (loaded from application.properties file)
     *
     * @return main application properties
     */
    public static Properties getAppProps() {
        if (appProps == null) {
            // synchronize inside null check so only first attempt gets synchronized
            synchronized (appPropsLock) {
                // null check again so only first thread to get this far will ever
                // run the load block
                if (appProps == null) {
                    appProps = loadProperties(getValidFilePath("application.properties"));
                    if (appProps == null) {
                        logger.fatal(nl
                                + StringUtil.formatFatalMsg("FAILED TO LOAD APPLICATION PROPERTIES"));
                    }
                }
            }
        }
        return appProps;
    }

    /**
     * Get log4j properties (loaded from log4j.properties file)
     *
     * @return main application properties
     */
    public static Properties getLogProps() {
        if (logProps == null) {
            // synchronize inside null check so only first attempt gets synchronized
            synchronized (logPropsLock) {
                // null check again so only first thread to get this far will ever
                // run the load block
                if (logProps == null) {
                    logProps = loadProperties(getValidFilePath("log4j.properties"));
                    if (logProps == null) {
                        logger.fatal(nl
                                + StringUtil.formatFatalMsg("FAILED TO LOAD LOG4J PROPERTIES"));
                    }
                }
            }
        }
        return logProps;
    }

    public static String getAppPropValue(String key) {
        return getAppPropValue(key, null);
    }

    public static String getAppPropValue(String key, String defaultValue) {
        String value = null;
        Properties appProps = getAppProps();
        if (appProps != null) {
            value = appProps.getProperty(key, defaultValue);
        }
        return value;
    }

    private static SimpleDateFormat guidFormatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    /**
     * Create a Global Unique Identifier
     *
     * @return a global unique identifier
     */
    public static String createGUID() {
        String randno = String.valueOf((long) (100000000000000L * Math.random()));
        // pad to 14 chars
        while (randno.length() < 14) {
            randno = "0" + randno;
        }
        String uid = guidFormatter.format(new java.util.Date()) + randno;
        String guid = new BigInteger(uid).toString(36).toUpperCase();
        return guid;
    }

    /**
     * Loads the specified properties file name from (application home
     * path)/Properties. Once the properties file is loaded, all values (not
     * keys) are scannned for the text ${app.home.path} and anywhere that is
     * found it is replaced with the application home path that was used to load
     * the properties in the first place. The value inserted will not have a
     * trailing "file.seperator" character.
     *
     *
     * @param filePath filename with path of properties file
     * @return loaded properties file or null if error occured
     */
    public static Properties loadProperties(String filePath) {
        Properties props = null;
        if (filePath != null) {
            InputStream inputStream = null;
            props = new Properties();
            try {
                inputStream = GlobalResources.class.getClassLoader().getResourceAsStream(filePath);
                props.load(inputStream);
                if (logger.isDebugEnabled()) {
                    logger.debug(nl + filePath + " loaded.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error(">>>>>>>>>>>>>>>>>>>>  Failed to load file=\"" + filePath + "\"", ex);
                props = null;
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e) {
                    // Ignore
                }

            }
        }
        return props;
    }

    // Override log4j setup some properties 
    public static void updateLogProperty(String key, String value) {
        if (key != null && value != null) {
            Properties logProps = getLogProps();
            if (logProps != null) {
                logProps.setProperty(key, value);
                LogManager.resetConfiguration();
                PropertyConfigurator.configure(logProps);
            }
        }
    }

    /*To set specific log file and reset later with original*/
    public static void resetLoggerFile(String newLogFile) {
        Properties logProps = getLogProps();
        if (logFile == null) {
            logFile = logProps.getProperty("log4j.appender.applog.File");
        }
        if (!logFile.equals(newLogFile)) {
            newLogFile = logFile.substring(0, logFile.indexOf("/LogFiles/") + 10) + newLogFile;
        }
        logProps.setProperty("log4j.appender.applog.File", newLogFile);
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(logProps);
    }

    // Update log4j level like ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF 
    public static void updateLogLevel(String debugLevel) {

        if (debugLevel != null) {
            Logger rootLogger = Logger.getRootLogger();
            logger.debug("Current debeg level log - " + rootLogger.getLevel().toString());
            switch (debugLevel.toUpperCase()) {
                case "ALL": {
                    rootLogger.setLevel(Level.ALL);
                    break;
                }
                case "TRACE": {
                    rootLogger.setLevel(Level.TRACE);
                    break;
                }
                case "DEBUG": {
                    rootLogger.setLevel(Level.DEBUG);
                    break;
                }
                case "INFO": {
                    rootLogger.setLevel(Level.INFO);
                    break;
                }
                case "WARN": {
                    rootLogger.setLevel(Level.WARN);
                    break;
                }
                case "ERROR": {
                    rootLogger.setLevel(Level.ERROR);
                    break;
                }
                case "FATAL": {
                    rootLogger.setLevel(Level.FATAL);
                    break;
                }
                case "OFF": {
                    rootLogger.setLevel(Level.OFF);
                    break;
                }
            }
        }
    }

    private static String findEntryInProps(String key, Properties props) {
        String value = null;
        Set entries = props.entrySet();
        for (Iterator i = entries.iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry) i.next();
            if (key.equalsIgnoreCase((String) entry.getKey())) {
                value = (String) entry.getValue();
                break;
            }
        }
        return value;
    }

    public static String getValidFilePath(String filePath) {
        if (filePath != null) {
            String fileSeparator = System.getProperties().getProperty("file.separator");
            filePath = filePath.replace(fileSeparator, "/");
        }
        return filePath;
    }

    public static String getDefaultAccount() {
        return getAppPropValue("default.db.account", "OPHAVER").toUpperCase();
    }

    public static void initScheduler() {
        try {
            String jobExecutable = getAppPropValue("jobscheduler.isexecutable", "false");
            if (Boolean.valueOf(jobExecutable)) {
                if (logger.isDebugEnabled()) {
                    logger.debug(nl + "initializing Job Scheduler.");
                }
                AppUtil.callMethod("com.sch.job.QuartzJobScheduler", "invokeJobInvoker", new Object[]{getAppPropValue("jobscheduler.lookup.intervalInMinutes")});
                if (logger.isDebugEnabled()) {
                    logger.debug(nl + "Job Scheduler initialized.");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>>>>  Failed to initialize Job Scheduler=", ex);
        }
    }
}
