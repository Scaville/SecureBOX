package com.Scaville.SecureBox.Hash;

import com.Scaville.SecureBox.Common.Algorithm;

public class SHA384 {

    public static String hash(String value) throws Exception {
        return HASH.hash(value,Algorithm.SHA_384.getValue());
    }

    public static String hmac(String value, String key) throws Exception{
        return HMAC.hash(value,key,Algorithm.SHA_384_HMAC.getValue());
    }
}
