package com.br.investimentos.mapper;

import com.br.investimentos.dto.UserDto;
import com.br.investimentos.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
