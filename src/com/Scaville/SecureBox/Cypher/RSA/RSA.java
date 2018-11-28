package com.Scaville.SecureBox.Cypher.RSA;

import javax.crypto.Cipher;

import com.Scaville.SecureBox.Common.Algorithm;
import com.Scaville.SecureBox.Common.SecureBox;

public class RSA {
    private Chain chain;

    public RSA(Chain chain) {
        this.chain = chain;
    }

    public byte[] crypt(String value) throws Exception {
        return this.cryptEngine(value,false);
    }

    public byte[] crypt(String value, boolean reverse) throws Exception {
        return this.cryptEngine(value, reverse);
    }

    public String decrypt(byte[] value) throws Exception {
        return this.decryptEngine(value,false);
    }

    public String decrypt(byte[] value, boolean reverse) throws Exception {
        return this.decryptEngine(value, reverse);
    }

    private byte[] cryptEngine(String value, boolean reverse) throws Exception{
        byte[] cipherText = null;

        final Cipher cipher = Cipher.getInstance(Algorithm.RSA.getValue());
        if (reverse) {
            cipher.init(Cipher.ENCRYPT_MODE, this.chain.getPrivate());
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, this.chain.getPublic());
        }
        cipherText = cipher.doFinal(value.getBytes(SecureBox.encoding));

        return cipherText;
    }

    private String decryptEngine(byte[] value, boolean reverse) throws Exception{
        byte[] dectyptedText = null;

        final Cipher cipher = Cipher.getInstance(Algorithm.RSA.getValue());
        if (reverse) {
            cipher.init(Cipher.DECRYPT_MODE, this.chain.getPublic());
        } else {
            cipher.init(Cipher.DECRYPT_MODE, this.chain.getPrivate());
        }
        dectyptedText = cipher.doFinal(value);

        return new String(dectyptedText);
    }

}
