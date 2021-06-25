package com.example.generate.utils;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;

import javax.validation.ValidationException;

import org.apache.logging.log4j.util.Strings;

public class CerLoador {

    private String storefile = "";
    private String password = "123qweASD..";

    public CerLoador(String keyPath, String password) throws ValidationException {
        if (Strings.isBlank(password) || Strings.isBlank(keyPath) ) {
            throw new ValidationException("Construction parameters must be not empty");
        }
        this.storefile = keyPath;
        this.password = password;
    }

    public byte[] getSignature() {
        KeyStore store = null;

        try (
            FileInputStream stream = new FileInputStream(storefile);
        ) {
            store = KeyStore.getInstance("JKS");
            store.load(stream, password.toCharArray());
        } catch (Exception e) {
            // do something
            e.printStackTrace();
        }

        try {
            X509Certificate x509Certificate = (X509Certificate) store.getCertificate("fingerprint");
            
            return x509Certificate.getSignature();
        } catch (KeyStoreException e) {
            // do something
            e.printStackTrace();
        }
        
        return null;
    }
}
