package com.vois.bank.BankSystem.api.resource.account;

import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.entity.Transaction;
import com.vois.bank.BankSystem.service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {

    private double balance;
    private User user;
    private AccountNature accountNature;
    private List<Transaction> fromTransactions;

}
