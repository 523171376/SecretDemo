package com.example.generate.base;

public interface ICoding {

    String encode(String target, String key, int length);

    boolean decode(String target, String key, int length);
}
