package com.base.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Raman
 */
public class CryptoUtil {
	
	 public static final String ENCRYPT_DECRYPT_ALGO = "AES";

   public static String encryptValue(String Value, String userId) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalStateException, IllegalBlockSizeException, BadPaddingException {
        if(Value == null){
            return null;
        }
        userId = userId != null ? userId : ENCRYPT_DECRYPT_ALGO; 
        byte[] keyBytes = new byte[16];
        byte[] userIdBytes = userId.getBytes();
        int length = keyBytes.length;
        int userLength = userIdBytes.length;
        if (length > userLength) {
            length = userLength;
        }
        System.arraycopy(userIdBytes, 0, keyBytes, 0, length);
        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, ENCRYPT_DECRYPT_ALGO);
        Cipher cipher = Cipher.getInstance(ENCRYPT_DECRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] rowBytes = cipher.doFinal(Value.getBytes());
        return StringUtil.toHex(rowBytes);
    }

    public static String decryptEncryptedValue(String encryptValue, String userId) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalStateException, IllegalBlockSizeException, BadPaddingException  {
        if(encryptValue == null){
            return null;
        }
        userId = userId != null ? userId : ENCRYPT_DECRYPT_ALGO; 
        byte[] keyBytes = new byte[16];
        byte[] userIdBytes = userId.getBytes();
        int length = keyBytes.length;
        int userLength = userIdBytes.length;
        if (length > userLength) {
            length = userLength;
        }
        System.arraycopy(userIdBytes, 0, keyBytes, 0, length);
        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, ENCRYPT_DECRYPT_ALGO);
        Cipher cipher = Cipher.getInstance(ENCRYPT_DECRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] originalBytes = cipher.doFinal(StringUtil.fromHex(encryptValue));
        return new String(originalBytes);
    }
   
}
