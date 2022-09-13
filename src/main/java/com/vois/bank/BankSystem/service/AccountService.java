package com.vois.bank.BankSystem.service;

import com.vois.bank.BankSystem.service.entity.Account;

import java.util.List;

public interface AccountService {
    public Account addAccount(Account account);

    public List<Account> getAllAccount();
    public Account getAccountByID(String id);
}
