package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.dao.AccountDao;
import com.vois.bank.BankSystem.service.dao.AccountNatureDao;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountNatureDaoImpl implements AccountNatureDao {

    private final AccountNatureRepo accountNatureRepo;

    public AccountNatureDaoImpl(AccountNatureRepo accountNatureRepo) {
        this.accountNatureRepo = accountNatureRepo;
    }

    @Override
    public AccountNature save(AccountNature entity) {
        return accountNatureRepo.save(entity);
    }

    @Override
    public AccountNature update(AccountNature entity) {
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return accountNatureRepo.save(entity);
    }

    @Override
    public Optional<AccountNature> findById(Integer id) {
        return accountNatureRepo.findById(id);
    }

    @Override
    public List<AccountNature> findAll() {
        return accountNatureRepo.findAll();
    }

    @Override
    public Optional<AccountNature> findByNature(String nature) {
        return accountNatureRepo.findByNature(nature);
    }
}
