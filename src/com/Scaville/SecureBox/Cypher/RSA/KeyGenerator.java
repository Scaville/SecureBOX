package com.Scaville.SecureBox.Cypher.RSA;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import com.Scaville.SecureBox.Common.Algorithm;


public class KeyGenerator {

    public KeyGenerator(File privateKeyFile, File publicKeyFile) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(Algorithm.RSA.getValue());
        keyGen.initialize(2048);
        KeyPair chain = keyGen.generateKeyPair();
        if(!privateKeyFile.exists()) {
        	privateKeyFile.createNewFile();        	
        }
        FileOutputStream os_private = new FileOutputStream(privateKeyFile);
        os_private.write(chain.getPrivate().getEncoded());
        os_private.flush();
        os_private.close();
        if(!publicKeyFile.exists()) {
        	publicKeyFile.createNewFile();        	
        }
        FileOutputStream os_public = new FileOutputStream(publicKeyFile);
        os_public.write(chain.getPublic().getEncoded());
        os_public.flush();
        os_public.close();
    }
}
