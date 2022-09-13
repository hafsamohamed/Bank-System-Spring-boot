package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Integer userName);
    List<Role> findAll();
}
