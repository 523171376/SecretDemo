package com.example.generate.base.impl;

import java.util.HashSet;
import java.util.Set;

import com.example.generate.base.AbstractSecretAction;
import com.example.generate.base.IVerification;
import com.example.generate.utils.Strings;

public class KeyVerificator extends AbstractSecretAction implements IVerification {

    public KeyVerificator(int seed) {
        super(seed);
    }

    @Override
    public boolean verifing(String key0, String key1, int length) {
        Set<String> should = new HashSet<>();
        
        int[] indexs = secret.greateIndex(KeyGenerator.SECRET_KEY_LENGTH, length);
        should.add(Strings.reverse(key0, indexs));

        indexs = secret.greateIndex(KeyGenerator.SECRET_KEY_LENGTH, length * 2);
        should.add(Strings.reverse(key1, indexs));

        return should.size() == 1;
    }
}
