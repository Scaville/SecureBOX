package com.Scaville.SecureBox.Hash;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.Scaville.SecureBox.Common.SecureBox;

public class HMAC {
    public static String hash(String value, String key, String algo) throws Exception{
        SecretKeySpec secretKey = new SecretKeySpec( key.getBytes(SecureBox.encoding), algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(secretKey);

        byte[] digest = mac.doFinal(value.getBytes(SecureBox.encoding));

        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(0xFF & digest[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }

        return hash.toString();
    }
}
