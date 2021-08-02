package com.base.common.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Collection;
import java.math.BigDecimal;

public class StringUtil extends Object
{
   private static String nl = System.getProperties().getProperty("line.separator");

   public static String dumpMap(Map map)
   {
      StringBuffer sb = new StringBuffer();

      Set entries = map.entrySet();
      for (Iterator i = entries.iterator(); i.hasNext();)
      {
         Map.Entry entry = (Map.Entry)i.next();
         sb.append(entry.getKey()).append("=").append(entry.getValue()).append(nl);
      }

      return sb.toString();
   }

   public static String dumpProps(Properties properties)
   {
      StringBuffer sb = new StringBuffer();

      ArrayList keyList = new ArrayList();
      for (Enumeration enumer = properties.propertyNames(); enumer.hasMoreElements();)
      {
         keyList.add(enumer.nextElement());
      }

      String[] keys = new String[keyList.size()];
      keyList.toArray(keys);
      Arrays.sort(keys);

      for (int i = 0; i < keys.length; i++)
      {
         String name = keys[i];
         String value = properties.getProperty(name);
         sb.append(name).append("=").append(value).append(nl);
      }

      return sb.toString();
   }

   public static String nullToEmpty(Object s)
   {
      if (s == null) return "";
      return s.toString();
   }

   /**
    * Converts the specified String to a BigDecimal if possible but returns null if
    * any Exception occurs.  This is useful for "inline" conversions where it is known
    * that the String can always be safely converted or when errors are of no concern.
    *
    * @param s  String to convert to a BigDecimal
    * @return   the BigDecimal value of the String or null if any error or Exception occurs
    */
   public static BigDecimal stringToBigDecimal(String s)
   {
      BigDecimal bd = null;
      try{  bd = new BigDecimal(s);  }catch(NumberFormatException e){/*do nothing*/}
      return bd;
   }


   /**
    * Replaces all occurrences of the search String in the specified source String
    * with the specified replacement String.
    *
    * @param source   String find the search String and replace with the replace String
    * @param search   String to search for in the source String
    * @param replace  String to replace all occurrences of the search String
    * @return String  the original with all occurrences of search String replaced
    *                 with replace String
    */
   public static String replace(String source, String search, String replace)
   {
      if (search != null && search.length() > 0)
      {
         source = nullToEmpty(source);
         replace = nullToEmpty(replace);

         StringBuffer sb = new StringBuffer(source);

         int searchLength = search.length();
         int replaceLength = replace.length();

         int startIdx = 0;
         int searchIdx = sb.toString().indexOf(search, startIdx);

         while (searchIdx > -1)
         {
            sb.replace(searchIdx, searchIdx + searchLength, replace);
            startIdx = searchIdx + replaceLength;
            if (startIdx < sb.length())
            {
               searchIdx = sb.toString().indexOf(search, startIdx);
            }
            else
            {
               searchIdx = -1;
            }
         }

         return sb.toString();
      }
      else
      {
         return source;
      }
   }

   /**
    * Takes the specified message and surrounds it with a flower box and the
    * words FATAL ERROR in spaced letters so as to provide a message that draws
    * attention to itself in a log file.
    *
    * @param msg the message to format
    * @return the formatted message
    */
   public static String formatFatalMsg(String msg)
   {
      StringBuffer formattedMsg = new StringBuffer(
         "**********************************************************************" +
         nl +
         "**********************  F A T A L   E R R O R  ***********************" +
         nl);
      if (msg != null && msg.length() > 0)
      {
         formattedMsg.append("***   ").append(
            replace(msg, nl, nl + "***   ")
         ).append(nl);
      }
      return formattedMsg.append(
         "**********************************************************************" +
         nl).toString();
   }

   /**
    * Convenience method to convert a byte array to a String of Base 64 chars.
    *
    * @param bytes the byte array to convert
    * @return a String with Base 64 chars
    */
   public static String toBase64(byte[] bytes)
   {
      return Base64.encodeBytes(bytes);
   }

   /**
    * Convenience method to convert a String of Base 64 chars to a byte array.
    *
    * @param base64 the string of Base 64 characters to convert
    * @return an array of bytes represented by the string of Base 64 chars
    */
   public static byte[] fromBase64(String base64)
   {
      return Base64.decode(base64);
   }

   /**
    * Convenience method to convert a byte array to a String of hex chars. There
    * will be 2 hex chars per byte.
    *
    * @param bytes the byte array to convert
    * @return a String with 2 hex chars per byte
    */
   public static String toHex(byte[] bytes)
   {
      StringBuffer sb = new StringBuffer(bytes.length * 2);
      for (int i = 0; i < bytes.length; i++)
      {
         sb.append(toHex(bytes[i]));
      }
      return sb.toString();
   }

   /**
    * Convenience method to convert a String of hex chars to a byte array. There
    * must be 2 hex chars per byte.
    *
    * @param hex the string of hex characters to convert
    * @return an array of bytes represented by the string of hex chars
    */
   public static byte[] fromHex(String hex)
   {
      hex = hex.toLowerCase();
      byte[] bytes = new byte[hex.length() / 2];
      int idx = 0;
      for (int i = 0; i < bytes.length; i++)
      {
         idx = i * 2;
         bytes[i] = fromHex(hex.charAt(idx++), hex.charAt(idx++));
      }
      return bytes;
   }

   /**
    * Convenience method to convert a byte to 2 hex chars.
    *
    * @param b the byte to convert
    * @return a String with 2 hex chars
    */
   private static String toHex(byte b)
   {
      StringBuffer sb = new StringBuffer(2);
      sb.append(toHexChar((b >>> 4) & 0x0F));
      sb.append(toHexChar(b & 0x0F));
      return sb.toString();
   }

   /**
    * Convenience method to convert an int to a hex char.
    *
    * @param i the int to convert
    * @return char the converted char
    */
   private static char toHexChar(int i)
   {
      if ((0 <= i) && (i <= 9))
      {
         return (char)('0' + i);
      }
      else
      {
         return (char)('a' + (i - 10));
      }
   }

   /**
    * Convenience method to convert 2 hex chars to a byte.
    *
    * @param hexChar1 the hex char representing the top 4 bits of the byte
    * @param hexChar2 the hex char representing the bottom 4 bits of the byte
    * @return the byte made of the two hex chars
    */
   private static byte fromHex(char hexChar1, char hexChar2)
   {
      return (byte)((fromHexChar(hexChar1) * 16) + fromHexChar(hexChar2));
   }

   /**
    * Convenience method to convert a hex char to an int.
    *
    * @param hexChar the char to convert
    * @return int value of the hex char
    */
   private static int fromHexChar(char hexChar)
   {
      if (hexChar > '9')
      {
         return hexChar - 'a' + 10;
      }
      else
      {
         return hexChar - '0';
      }
   }

   /**
    * Pads the specified String on the left to the specified length using the
    * specified pad character.  If the specified String is longer than the
    * specified length then no action is taken and the original String is
    * returned.
    *
    * @param s String to pad on the left
    * @param l length to which to pad the String
    * @param c character to use to do the padding
    * @return String  the original string padded to the specified length
    */
   public static String padLeft(String s, int l, char c)
   {
      s = nullToEmpty(s);
      StringBuffer sb = new StringBuffer(s);
      for (int i = sb.length(); i < l; i++)
      {
         sb.insert(0, c);
      }
      return sb.toString();
   }

   /**
    * Pads the specified String on the right to the specified length using the
    * specified pad character.  If the specified String is longer than the
    * specified length then no action is taken and the original String is
    * returned.
    *
    * @param s String to pad on the right
    * @param l length to which to pad the String
    * @param c character to use to do the padding
    * @return String  the original string padded to the specified length
    */
   public static String padRight(String s, int l, char c)
   {
      s = nullToEmpty(s);
      StringBuffer sb = new StringBuffer(s);
      for (int i = sb.length(); i < l; i++)
      {
         sb.append(c);
      }
      return sb.toString();
   }

	public static String defaultValue(String s, String value)
	{
		if (s == null || s.length() == 0)
		{
			return value;
		}
		else
		{
			return s;
		}
	}
	public static String defaultValue(Object o, String value)
	{
		if (o == null  ||  o.toString().length() == 0)
		{
			return value;
		}
		else
		{
			return o.toString();
		}
	}

   /**
     * Concantenates the String format of the members of the specified Collection
     * together and places the specified delimiter between values to produce one
     * long String which is a delimited list of values.
     *
     * @param collection  any Collection of objects, typically String objects though;
     *                    if the Collection is null then it is treated as an empty
     *                    Collection
     * @param delimiter   value to place betwee each member of the Collection; if
     *                    delimiter is null then it is treated as an empty String
     *
     * @return  a long String which is the String value of the members of the
     *          Collection concantenated together with the delimiter placed between
     *          each value
     */
    public static String buildDelimitedString(Collection collection, String delimiter)
    {
       StringBuffer result = new StringBuffer();
       delimiter = nullToEmpty(delimiter);
       if (collection != null)
       {
          boolean needDelimiter = false;
          for (Iterator i = collection.iterator(); i.hasNext();)
          {
             Object o = i.next();
             if (o != null)
             {
                if (needDelimiter)
                {
                   result.append(delimiter);
                }
                needDelimiter = true;
                result.append(o.toString());
             }
          }
       }
       return result.toString();
    }

   /**
    * Converts the specified String to an int if possible but returns 0 if any
    * Exception occurs.  This is useful for "inline" conversions where it is known
    * that the String can always be safely converted to an int or when errors are
    * of no concern.
    *
    * @param s     String to convert to an int
    * @return int  int value of the String or 0 if any error or Exception occurs
    */
   public static int stringToInt(String s)
   {
      int i = 0;
      try{  i = Integer.valueOf(s).intValue();  }catch(NumberFormatException e){/*do nothing*/}
      return i;
   }
   
   /**
    * This method is responsible to remove trailing asterisks from the given parameter string 
    * value and return same string value without trailing asterisks.
    * @param line String value
    * @return String return the string without trailing asterisks. 
    */
   public static String getStringWithoutTrailingAsk(String line) {
        String newLine = line;
        String[] values = line.split("\\*+~$");        
        if (values[0].length() != line.length()) {
            newLine = values[0] + "~";
        }       
        return newLine;
    }

   
}