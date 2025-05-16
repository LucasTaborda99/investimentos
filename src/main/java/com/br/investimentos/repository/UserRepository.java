package com.br.investimentos.repository;

import com.br.investimentos.dto.UserDto;
import com.br.investimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findUserByEmail(String email);
}
