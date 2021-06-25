package com.example.generate.base;

import com.example.generate.utils.Randoms;

public class Secret {
    private Randoms randoms;

    public Secret(int seed) {
        randoms = new Randoms(seed);
    }

    public String greateSign(int limit) {
        return randoms.nextString(limit);
    }

    public int[] greateIndex(int limit, int max) {
        return randoms.findIndex(limit, max);
    }
}
