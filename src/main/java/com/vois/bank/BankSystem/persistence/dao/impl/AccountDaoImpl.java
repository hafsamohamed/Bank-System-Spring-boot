package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.dao.AccountDao;
import com.vois.bank.BankSystem.service.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao {

    private final AccountRepo accountRepo;

    public AccountDaoImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


    @Override
    public Account save(Account entity) {
        return accountRepo.save(entity);
    }

    @Override
    public Account update(Account entity) {
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return accountRepo.save(entity);
    }


    @Override
    public Optional<Account> findById(String id) {
        return accountRepo.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }
}
