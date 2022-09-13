package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
    Optional<User> findByUserName(String userName);
    Optional<User> findById(Integer id);
    List<User> findAll();
}
