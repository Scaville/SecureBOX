package com.Scaville.SecureBox.Cypher.DES;

import java.io.File;
import java.io.FileOutputStream;
import javax.crypto.SecretKey;

import com.Scaville.SecureBox.Common.Algorithm;


public class KeyGenerator {

    public static byte[] generate() throws Exception {
        return generateEngine(128);
    }

    public static byte[] generate(int size) throws Exception {
        return generateEngine(size);
    }

    public static byte[] generate(File file, int size) throws Exception{
        byte[] buffer = generateEngine(size);
        writeFile(file, buffer);
        return buffer;
    }

    public static byte[] generate(File file) throws Exception{
        byte[] buffer = generateEngine(128);
        writeFile(file, buffer);
        return buffer;
    }

    private static void writeFile(File file, byte[] buffer) throws Exception {
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fs = new FileOutputStream(file);
        fs.write(buffer);
        fs.flush();
        fs.close();
    }

    private static byte[] generateEngine(int size) throws Exception {
        javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance(Algorithm.DES.getValue());
        keyGen.init(size);
        SecretKey key = keyGen.generateKey();
        return key.getEncoded();
    }

}
