package com.example.generate.utils;

public class Secrets {

    public static int getSeed(String key, byte[] sign) {
        String temp = String.format("%s%s", MD5.encode(sign), MD5.encode(key.getBytes()));
        StringBuilder tempBuilder = new StringBuilder();
        int count = 0;
        for (int i = 1; i < temp.length() + 1; i++) {
            tempBuilder.append(String.valueOf(temp.charAt(i - 1) % 10));
            if (i % 8 == 0) {
                count += Integer.parseInt(tempBuilder.toString());
                tempBuilder.delete(0, 9);
            }
        }
        return count;
    }
}
