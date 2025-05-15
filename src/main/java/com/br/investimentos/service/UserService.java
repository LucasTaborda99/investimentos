package com.br.investimentos.service;

import com.br.investimentos.dto.UserDto;
import com.br.investimentos.entity.User;
import com.br.investimentos.mapper.UserMapper;
import com.br.investimentos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDto createUser(UserDto userDto) {
        // Convertendo DTO para Entity
        User userEntity = userMapper.toEntity(userDto);

        // Salvando entidade no repositório
        User savedUser = userRepository.save(userEntity);

        // Convertendo a entidade salva de volta para DTO
        return userMapper.toDto(savedUser);
    }

    public List<UserDto> listUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(userMapper::toDto)
                    .collect(Collectors.toList());
    }
}
