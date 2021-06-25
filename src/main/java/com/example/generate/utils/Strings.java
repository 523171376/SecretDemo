package com.example.generate.utils;

import java.util.Arrays;

public class Strings {

    public static String convert(String arg0, String arg1, int[] indexs) {
        byte[] target = arg0.getBytes();

        for (int i = 0; i < indexs.length; i++) {
            target[indexs[i]] = (byte)arg1.charAt(i);
        }
        return new String(target);
    }

    public static String reverse(String key, int[] indexs) {
        StringBuffer sb = new StringBuffer();
        Arrays.stream(indexs).forEach(i -> sb.append(key.charAt(i)));
        return sb.toString();
    }
}
