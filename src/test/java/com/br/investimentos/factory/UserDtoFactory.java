package com.br.investimentos.factory;

import com.br.investimentos.dto.UserDto;

import java.util.UUID;

public class UserDtoFactory {
    public static UserDto createDefaultUserDto() {
        return new UserDto(UUID.randomUUID(), "Jão", "jão@gmail.com", "123456");
    }
}
