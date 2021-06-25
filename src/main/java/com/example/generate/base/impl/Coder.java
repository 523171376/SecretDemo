package com.example.generate.base.impl;

import java.util.HashSet;
import java.util.Set;

import com.example.generate.base.AbstractSecretAction;
import com.example.generate.base.ICoding;
import com.example.generate.utils.MD5;
import com.example.generate.utils.Strings;

public class Coder extends AbstractSecretAction implements ICoding{
    private static final int SPLIT = 0x3D;
    
    public Coder(int seed) {
        super(seed);
    }

    @Override
    public String encode(String target, String key, int length) {
        int[] indexs = secret.greateIndex(KeyGenerator.SECRET_KEY_LENGTH, length);
        String sign= new StringBuilder(target).append(Strings.reverse(key, indexs)).toString();
        String res = String.format("%s&sign=%s", target, MD5.encode(sign.getBytes()));
        return res;
    }

    @Override
    public boolean decode(String target, String key, int length) {
        Set<String> should = new HashSet<>();

        int index = target.lastIndexOf(SPLIT);
        String base = target.substring(0, index - 5);
        should.add(target.substring(index + 1));
        
        int[] indexs = secret.greateIndex(KeyGenerator.SECRET_KEY_LENGTH, length * 2);
        String result = new StringBuilder(base).append(Strings.reverse(key, indexs)).toString();
        should.add(MD5.encode(result.getBytes()));

        return should.size() == 1;
    }
}
