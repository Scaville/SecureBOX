package com.Scaville.SecureBox.Cypher.AES;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.crypto.spec.SecretKeySpec;

import com.Scaville.SecureBox.Common.Algorithm;
import com.Scaville.SecureBox.Common.SecureBox;

import javax.crypto.Cipher;


public class AES{
    private SecretKeySpec key;
    private Cipher digest;

    public AES(File file) throws Exception {
        DataInputStream ds = new DataInputStream(new FileInputStream(file));
        byte[] buffer = new byte[(int) file.length()];
        ds.readFully(buffer);
        ds.close();
        this.factoryKey(buffer);
    }

    public AES(byte[] key) throws Exception{
        this.factoryKey(key);
    }

    public AES(String key) throws Exception {
        this.factoryKey(key.getBytes(SecureBox.encoding));
    }

    private void factoryKey(byte[] stream) throws Exception {
        this.digest = Cipher.getInstance(Algorithm.AES.getValue());
        this.key = new SecretKeySpec(stream, Algorithm.AES.getValue());
    }

    public byte[] encrypt(String value) throws Exception {
        this.digest.init(Cipher.ENCRYPT_MODE, this.key);
        return this.digest.doFinal(value.getBytes(SecureBox.encoding));
    }

    public String decrypt(byte[] value) throws Exception{
        this.digest.init(Cipher.DECRYPT_MODE, this.key);
        return new String(this.digest.doFinal(value),SecureBox.encoding);
    }

}
