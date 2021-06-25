package com.example.generate.base.impl;

import com.example.generate.base.AbstractSecretAction;
import com.example.generate.base.IGeneration;
import com.example.generate.base.Key;
import com.example.generate.utils.Randoms;
import com.example.generate.utils.Strings;

public class KeyGenerator extends AbstractSecretAction implements IGeneration {

    public static final int SECRET_KEY_LENGTH = 64;

    public KeyGenerator(int seed) {
        super(seed);
    }

    @Override
    public Key create(int length) {
        Key key = new Key();
        Randoms randoms = new Randoms();

        String sign = secret.greateSign(SECRET_KEY_LENGTH);
        int[] indexs = secret.greateIndex(SECRET_KEY_LENGTH, length);
        key.setPrivateKey(Strings.convert(randoms.nextString(length), sign, indexs));

        indexs = secret.greateIndex(SECRET_KEY_LENGTH, length * 2);
        key.setPublicKey(Strings.convert(randoms.nextString(length * 2), sign, indexs));

        return key;
    }

}
