package com.vois.bank.BankSystem.api.resource.authentication;

import com.vois.bank.BankSystem.service.enums.EAccountNature;
import com.vois.bank.BankSystem.service.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {

    private String userName;
    private String password;
    private String account_id;
    private int balance;
    private Integer account_nature_id;
    private List<Integer> roles_ids;

}
