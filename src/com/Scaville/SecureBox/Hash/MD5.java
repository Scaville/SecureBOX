package com.Scaville.SecureBox.Hash;

import com.Scaville.SecureBox.Common.Algorithm;

public class MD5 {

    public static String hash(String value) throws Exception {
        return HASH.hash(value,Algorithm.MD5.getValue());
    }

    public static String hmac(String value, String key) throws Exception{
        return HMAC.hash(value,key,Algorithm.MD5_HMAC.getValue());
    }
}
