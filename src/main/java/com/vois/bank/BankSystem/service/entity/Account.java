package com.vois.bank.BankSystem.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    private String id;

    @Column(name = "balance")
    private double balance;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "account_nature_id")
    @JsonIgnore
    private AccountNature accountNature;

    @OneToMany(mappedBy = "fromAccount", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<Transaction> fromTransactions;

    public Account(String id, double balance, User user, AccountNature accountNature) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.accountNature = accountNature;
    }
}
