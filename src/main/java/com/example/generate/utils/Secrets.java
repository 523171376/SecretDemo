package com.example.generate.utils;

public class Secrets {

    public static int getSeed(String key, byte[] sign) {
        String temp = String.format("%s%s", MD5.encode(sign), MD5.encode(key.getBytes()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i+= 16) {
            sb.append(String.valueOf((int) temp.charAt(i)));
        }
        return Integer.parseInt(sb.toString());
    }
}
