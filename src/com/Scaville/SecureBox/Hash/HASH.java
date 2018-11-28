package com.Scaville.SecureBox.Hash;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.Scaville.SecureBox.Common.SecureBox;

public class HASH {
    public static String hash(String value, String algo) throws Exception{
        MessageDigest digest = MessageDigest.getInstance(algo);
        digest.update(value.getBytes(SecureBox.encoding),0,value.length());
        return new BigInteger(1,digest.digest()).toString(16);
    }
}
