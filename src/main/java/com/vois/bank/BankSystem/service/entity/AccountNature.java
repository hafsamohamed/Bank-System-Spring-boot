package com.vois.bank.BankSystem.service.entity;

import com.vois.bank.BankSystem.service.enums.EAccountNature;
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
@Table(name = "account_nature")
public class AccountNature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nature", unique = true, length = 20)
    private EAccountNature nature;

//    @OneToOne(mappedBy = "accountNature", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountNature")
    private List<Account> accounts;

    public AccountNature(EAccountNature nature, List<Account> accounts) {
        this.nature = nature;
        this.accounts = accounts;
    }
}
