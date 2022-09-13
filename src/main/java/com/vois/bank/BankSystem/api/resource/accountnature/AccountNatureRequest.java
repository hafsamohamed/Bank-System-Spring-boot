package com.vois.bank.BankSystem.api.resource.accountnature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountNatureRequest implements Serializable {
    private String nature;
}
