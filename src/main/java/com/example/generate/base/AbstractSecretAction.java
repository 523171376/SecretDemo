package com.example.generate.base;

public abstract class AbstractSecretAction {
    protected Secret secret;

    public AbstractSecretAction(int seed) {
        this.secret = new Secret(seed);
    }
}
