package com.vois.bank.BankSystem.service.impl;

import com.vois.bank.BankSystem.service.AccountNatureService;
import com.vois.bank.BankSystem.service.dao.AccountNatureDao;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountNatureImpl implements AccountNatureService {
    @Autowired
    AccountNatureDao accountNatureDao;

    @Override
    public AccountNature getById(int id) {
        return accountNatureDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account nature with id " + id + ", not found"));
    }

    @Override
    public AccountNature getByNature(String name) {
        return accountNatureDao.findByNature(name).orElseThrow(() -> new ResourceNotFoundException("Account nature with name " + name + ", not found"));
    }

    @Override
    public List<AccountNature> getAllAccountNature() {
        return accountNatureDao.findAll();
    }

    @Override
    public AccountNature addAccountNature(AccountNature accountNature) {
        return accountNatureDao.save(accountNature);
    }
}
