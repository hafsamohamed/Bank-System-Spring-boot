package com.vois.bank.BankSystem.api.resource.accountnature;

import com.vois.bank.BankSystem.service.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountNatureDto implements Serializable {

    private Integer id;
    private String nature;
}
