package com.example.generate.base;

public class Key {
    private String privateKey;
    private String publicKey;
    
    public Key() {
        super();
    }
    public Key(String privateKey, String publicKey) {
        super();
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
    public String getPrivateKey() {
        return privateKey;
    }
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    
}
