package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountNatureRepo extends JpaRepository<AccountNature, Integer> {
    @Query("select a from AccountNature a where a.id = :id")
    Optional<AccountNature> findById(@Param("id")Integer id);
    Optional<AccountNature> findByNature(String nature);
    List<AccountNature> findAll();
}
