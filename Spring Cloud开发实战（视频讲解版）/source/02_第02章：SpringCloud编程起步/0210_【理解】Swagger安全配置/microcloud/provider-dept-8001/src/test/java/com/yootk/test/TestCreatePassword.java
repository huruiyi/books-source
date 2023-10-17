package com.yootk.test;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class TestCreatePassword {
    public static void main(String[] args) {
        String pwd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("yootk");
        System.out.println(pwd);
    }
}
