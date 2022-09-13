package com.vois.bank.BankSystem.service;

import com.vois.bank.BankSystem.service.entity.AccountNature;

import java.util.List;

public interface AccountNatureService {
    public AccountNature getById(int id);
    public AccountNature getByNature(String name);
    public List<AccountNature> getAllAccountNature();

    public AccountNature addAccountNature(AccountNature accountNature);

}
