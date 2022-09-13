package com.vois.bank.BankSystem.api.resource.transaction;

import com.vois.bank.BankSystem.service.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto implements Serializable {

    private Integer id;
    private double amount;
    private Account fromAccount;
    private Account toAccount;
}
