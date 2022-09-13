package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, String> {
    Optional<Account> findById(String id);
    List<Account> findAll();
}
