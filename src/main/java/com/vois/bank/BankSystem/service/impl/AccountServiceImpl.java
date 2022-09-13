package com.vois.bank.BankSystem.service.impl;

import com.vois.bank.BankSystem.service.dao.AccountDao;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.AccountService;
import com.vois.bank.BankSystem.service.exception.ResourceAlreadyExistException;
import com.vois.bank.BankSystem.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountDao accountDao;

    @Override
    public Account addAccount(Account account) {
        Optional<Account> account1 = accountDao.findById(account.getId());
        if(account1.isPresent()){
            throw new ResourceAlreadyExistException("Account with id " + account.getId() + " , must be unique");
        }else {
            return accountDao.save(account);
        }
    }

    @Override
    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account getAccountByID(String id) {
        return accountDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with id " + id + ",not found"));

    }
}
