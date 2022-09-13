package com.vois.bank.BankSystem.api.resource.role;

import com.vois.bank.BankSystem.service.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleResponse implements Serializable {
    private Integer id;
    private ERole name;

}
