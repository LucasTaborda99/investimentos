package com.br.investimentos.factory;

import com.br.investimentos.entity.User;

import java.util.UUID;

public class UserFactory {
    public static User createDefaultUser() {
        return User.builder()
                .id(UUID.randomUUID())
                .name("Jão")
                .email("jão@gmail.com")
                .password("123456")
                .build();
    }
}
