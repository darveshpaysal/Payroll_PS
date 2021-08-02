package com.base.common.util;


import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer; 

/*import oracle.jdbc.driver.OracleSQLException;*/

public class MyLogger
{
   Logger logger = null;

   public MyLogger(String name)
   {
      logger = Logger.getLogger(name);
   }

   public MyLogger(Class clazz)
   {
      logger = Logger.getLogger(clazz);
   }

   public void debug(Object o)
   {
      logger.debug(getDebugInfo() + " -- " + o);
   }

   public void debug(Object o, Throwable t)
   {
      String debugInfo = getDebugInfo();
     /* if (t instanceof OracleSQLException)
      {
         logger.debug(debugInfo + " -- OracleSQLException parameters: " +
            getOracleSQLExceptionParameters((OracleSQLException)t));
      }*/
      logger.debug(debugInfo + " -- " + o, t);
   }

   public void info(Object o)
   {
      logger.info(o);
   }

   public void info(Object o, Throwable t)
   {
     /* if (t instanceof OracleSQLException)
      {
         logger.info("OracleSQLException parameters: " +
            getOracleSQLExceptionParameters((OracleSQLException)t));
      }*/
      logger.info(o, t);
   }

   public void warn(Object o)
   {
      logger.warn(o);
   }

   public void warn(Object o, Throwable t)
   {
     /* if (t instanceof OracleSQLException)
      {
         logger.warn("OracleSQLException parameters: " +
            getOracleSQLExceptionParameters((OracleSQLException)t));
      }*/
      logger.warn(o, t);
   }

   public void error(Object o)
   {
      logger.error(o);
   }

   public void error(Object o, Throwable t)
   {
     /* if (t instanceof OracleSQLException)
      {
         logger.error("OracleSQLException parameters: " +
            getOracleSQLExceptionParameters((OracleSQLException)t));
      }*/
      logger.error(o, t);
   }

   public void fatal(Object o)
   {
      logger.fatal(o);
   }

   public void fatal(Object o, Throwable t)
   {
     /* if (t instanceof OracleSQLException)
      {
         logger.fatal("OracleSQLException parameters: " + 
            getOracleSQLExceptionParameters((OracleSQLException)t));
      }*/
      logger.fatal(o, t);
   }

   public boolean isDebugEnabled()
   {
      return logger.isDebugEnabled();
   }

   public boolean isEnabledFor(Priority level)
   {
      return logger.isEnabledFor(level);
   }

   public boolean isInfoEnabled()
   {
      return logger.isInfoEnabled();
   }


   private int debugInfoStackDepth = 4;

   private String getDebugInfo()
   {
      if (debugInfoStackDepth > 0)
      {
         Throwable t = new Throwable();
         t.fillInStackTrace();
         String stackTrace = getStackTrace(t);

         StringTokenizer tok = new StringTokenizer(stackTrace, "\r\n");
         String line = null;
         int lineNumber = 0;

         // get the line in the stack dump that has the info we want
         while (tok.hasMoreTokens() && lineNumber < debugInfoStackDepth)
         {
            line = tok.nextToken();
            lineNumber++;
         }

         // get the module and line number info out of it
         if (line != null)
         {
            int startPosition = line.lastIndexOf('(');
            int endPosition = line.lastIndexOf(')');
            if (startPosition != -1 && endPosition != -1 && startPosition < endPosition)
            {
               return line.substring(startPosition, endPosition + 1);
            }
         }
      }
      return null;
   }

   private String getStackTrace(Throwable t)
   {
      StringWriter s = new StringWriter();
      t.printStackTrace(new PrintWriter(s));
      return s.toString();
   }

  /* private String getOracleSQLExceptionParameters(OracleSQLException ose)
   {
      StringBuffer sb = new StringBuffer();
      Object[] params = ose.getParameters();
      for (int i = 0; i < params.length; i++)
      {
         if (sb.length() > 0)
         {
            sb.append(" -- ");
         }
         sb.append(params[i]);
      }
      return sb.toString();
   }*/
}
