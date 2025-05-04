package com.br.investimentos.mapper;

import com.br.investimentos.dto.UserDto;
import com.br.investimentos.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
