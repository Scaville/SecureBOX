package com.Scaville.SecureBox.Cypher.DES;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.crypto.spec.SecretKeySpec;
import com.Scaville.SecureBox.Common.Algorithm;
import com.Scaville.SecureBox.Common.SecureBox;

import javax.crypto.Cipher;


public class DES{
    private SecretKeySpec key;
    private Cipher digest;

    public DES(File file) throws Exception {
        DataInputStream ds = new DataInputStream(new FileInputStream(file));
        byte[] buffer = new byte[(int) file.length()];
        ds.readFully(buffer);
        ds.close();
        this.factoryKey(buffer);
    }

    public DES(byte[] key) throws Exception{
        this.factoryKey(key);
    }

    public DES(String key) throws Exception {
        this.factoryKey(key.getBytes(SecureBox.encoding));
    }

    private void factoryKey(byte[] stream) throws Exception {
        this.digest = Cipher.getInstance(Algorithm.DES.getValue());
        this.key = new SecretKeySpec(stream, Algorithm.DES.getValue());
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
