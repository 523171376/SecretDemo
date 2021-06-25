package com.example.generate.utils;

import java.util.Random;

public class Randoms {
    private static final String CHARS = "aabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
    private static final int LENGTH = CHARS.length();
    private int seed = -1;
    private Random random;
    
    public Randoms() {
        random = new Random();
    }
    
    public Randoms(int seed) {
        this.seed = seed;
    }

    public String nextString(int limit) {
        if (seed != -1) {
            random = reset();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            sb.append(CHARS.charAt(random.nextInt(LENGTH)));
        }
        return sb.toString();
    }

    public int[] findIndex(int limit, int length) {
        if (seed != -1) {
            random = reset();
        }
        int[] index = new int[limit];
        for (int i = 0; i < limit; i++) {
            index[i] = random.nextInt(length);
        }
        return index;
    }
    
    private Random reset() {
        return new Random(seed);
    }
}
