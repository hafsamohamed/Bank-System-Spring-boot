package com.vois.bank.BankSystem.service.dao;

import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.AccountNature;

import java.util.Optional;

public interface AccountNatureDao extends GenericCrudDao<AccountNature, Integer>{
    Optional<AccountNature> findById(Integer id);
    Optional<AccountNature> findByNature(String nature);

}