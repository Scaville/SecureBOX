package com.Scaville.SecureBox.Cypher.RSA;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.Scaville.SecureBox.Common.Algorithm;


public class Chain {
    private PrivateKey pvk;
    private PublicKey pbk;

    public Chain(File privateKey, File publicKey) throws Exception {
    	DataInputStream private_is = new DataInputStream(new FileInputStream(privateKey));
    	DataInputStream public_is = new DataInputStream(new FileInputStream(publicKey));
        byte[] privateBuffer = new byte[(int) privateKey.length()];
        byte[] publicBuffer = new byte[(int) publicKey.length()];
        private_is.readFully(privateBuffer);
        private_is.close();
        public_is.readFully(publicBuffer);
        public_is.close();
        KeyFactory factory = KeyFactory.getInstance(Algorithm.RSA.getValue());
        this.pvk = factory.generatePrivate(new PKCS8EncodedKeySpec(privateBuffer)) ;
        this.pbk = factory.generatePublic(new X509EncodedKeySpec(publicBuffer)) ;
    }

    public PrivateKey getPrivate(){
        return this.pvk;
    }

    public PublicKey getPublic(){
        return this.pbk;
    }
}
