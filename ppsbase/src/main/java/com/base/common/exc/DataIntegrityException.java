package com.base.common.exc;

import java.sql.SQLException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class DataIntegrityException extends SQLException
{
    public static int DUPLICATE_KEY = 1;
   public static int PARENT_KEY_NOT_FOUND = 2291;
   public static int CHILD_RECS_EXIST = 2292;
   public static int TABLE_VIEW_NOT_EXIST = 942;
   public static int INSUFFICIENT_PRIVILEGES = 1031;
   String userMessage = null;
   SQLException sqlException = null;

   public DataIntegrityException(SQLException sqlException)
   {
      this(sqlException, null);
   }

   public DataIntegrityException(SQLException sqlException, String userMessage)
   {
      if (sqlException == null)
      {
         throw new IllegalArgumentException("The specified SQLException may not be null!");
      }
      this.sqlException = sqlException;
      setUserMessage(userMessage);
   }

   public String getUserMessage()
   {
      return userMessage;
   }

   public void setUserMessage(String userMessage)
   {
      this.userMessage = userMessage;
   }

   public void printStackTrace()
   {
      sqlException.printStackTrace();
   }

   public void printStackTrace(PrintStream printStream)
   {
      sqlException.printStackTrace(printStream);
   }

   public void printStackTrace(PrintWriter printWriter)
   {
      sqlException.printStackTrace(printWriter);
   }

   public StackTraceElement[] getStackTrace()
   {
      return sqlException.getStackTrace();
   }

   public void setStackTrace(StackTraceElement[] stackTraceElements)
   {
      sqlException.setStackTrace(stackTraceElements);
   }

   public String getLocalizedMessage()
   {
      return sqlException.getLocalizedMessage();
   }

   public String getMessage()
   {
      return sqlException.getMessage();
   }

   public String toString()
   {
      return DataIntegrityException.class.getName() + ": " + getUserMessage() +
         " -- " + sqlException.toString();
   }

   public Throwable getCause()
   {
      return sqlException.getCause();
   }

   public Throwable initCause(Throwable throwable)
   {
      return sqlException.initCause(throwable);
   }

   public int getErrorCode()
   {
      return sqlException.getErrorCode();
   }

   public String getSQLState()
   {
      return sqlException.getSQLState();
   }

   public SQLException getNextException()
   {
      return sqlException.getNextException();
   }

   public void setNextException(SQLException e)
   {
      sqlException.setNextException(e);
   }

   public boolean isDuplicateKeyError()
   {
      return (sqlException.getErrorCode() == DUPLICATE_KEY);
   }

   public boolean isParentKeyNotFoundError()
   {
      return (sqlException.getErrorCode() == PARENT_KEY_NOT_FOUND);
   }

   public boolean isChildRecsExistError()
   {
      return (sqlException.getErrorCode() == CHILD_RECS_EXIST);
   }
}
