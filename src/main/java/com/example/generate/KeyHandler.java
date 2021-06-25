package com.example.generate;

import java.util.Arrays;
import java.util.Objects;

import javax.validation.ValidationException;

import com.example.generate.base.ICoding;
import com.example.generate.base.IGeneration;
import com.example.generate.base.IVerification;
import com.example.generate.base.Key;
import com.example.generate.base.impl.Coder;
import com.example.generate.base.impl.KeyGenerator;
import com.example.generate.base.impl.KeyVerificator;
import com.example.generate.utils.CerLoador;
import com.example.generate.utils.Secrets;

public class KeyHandler {
    private static final String PATH_STRING = "src/main/resources/static/fingerprint.keystore";
    private static final String PWD_STRING = "123qweASD..";
    public static final int[] ALLOW_LENGTH = {512, 1024, 2048};
    private int length = 1024;
    private IGeneration generator;
    private IVerification verificator;
    private ICoding coder;
    private static KeyHandler instance;
    
    private KeyHandler(String uniqueKey) {
        CerLoador loador = new CerLoador(PATH_STRING, PWD_STRING);
        int seed = Secrets.getSeed(uniqueKey, loador.getSignature());
        generator = new KeyGenerator(seed);
        verificator = new KeyVerificator(seed);
        coder = new Coder(seed);
    }
    
    public static KeyHandler build(String uniqueKey) {
        if (Objects.isNull(instance)) {
            instance = new KeyHandler(uniqueKey);
        }
        return instance;
    }

    public KeyHandler setKeyLength(int length) {
        if (!Arrays.stream(ALLOW_LENGTH).anyMatch(value -> value == length)) {
            throw new ValidationException("length just allow 512, 1024, 2048");
        }

        this.length = length;
        return instance;
    }

    public Key getKey() {
        return generator.create(length);
    }

    public boolean check(String privateKey, String publicKey) {
        return verificator.verifing(privateKey, publicKey, length);
    }

    public String encode(String target, String key) {
        return coder.encode(target, key, length);
    }

    public boolean decoce(String target, String key) {
        return coder.decode(target, key, length);
    }
}
