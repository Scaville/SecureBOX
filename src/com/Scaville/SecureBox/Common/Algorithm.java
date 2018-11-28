package com.Scaville.SecureBox.Common;

public enum Algorithm {
    MD5_HMAC("HmacMD5"),
    SHA1_HMAC("HmacSHA1"),
    SHA_256_HMAC("HmacSHA256"),
    SHA_384_HMAC("HmacSHA384"),
    SHA_512_HMAC("HmacSHA512"),
    MD5("MD5"),
    RSA("RSA"),
    AES("AES"),
    DES("DES"),
    SHA_1("SHA-1"),
    SHA_256("SHA-256"),
    SHA_384("SHA-384"),
    SHA_512("SHA-512");

    private final String value;

    Algorithm(String algo){
        value = algo;
    }

    public String getValue(){
        return this.value;
    }
}
