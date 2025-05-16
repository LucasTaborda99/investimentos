package com.br.investimentos.service;

import com.br.investimentos.dto.UserDto;
import com.br.investimentos.entity.User;
import com.br.investimentos.factory.UserDtoFactory;
import com.br.investimentos.factory.UserFactory;
import com.br.investimentos.mapper.UserMapper;
import com.br.investimentos.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_ShouldReturnUserDto_WhenUserIsSaved() {
        // Arrange
        UserDto inputDto = UserDtoFactory.createDefaultUserDto();
        User userEntity = UserFactory.createDefaultUser();
        User savedUser = UserFactory.createDefaultUser();

        when(userRepository.findUserByEmail(inputDto.getEmail())).thenReturn(Optional.empty()); // Nenhum usuário existe
        when(userMapper.toEntity(inputDto)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(savedUser);
        when(userMapper.toDto(savedUser)).thenReturn(inputDto);

        // Act
        UserDto result = userService.createUser(inputDto);

        // Assert
        verify(userRepository).findUserByEmail(inputDto.getEmail());
        verify(userMapper).toEntity(inputDto);
        verify(userRepository).save(userEntity);
        verify(userMapper).toDto(savedUser);
    }

}