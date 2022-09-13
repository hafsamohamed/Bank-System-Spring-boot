package com.vois.bank.BankSystem.service.dao;

import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.AccountNature;

import java.util.Optional;

public interface AccountDao extends GenericCrudDao<Account, String>{

    Optional<Account> findById(String id);




}