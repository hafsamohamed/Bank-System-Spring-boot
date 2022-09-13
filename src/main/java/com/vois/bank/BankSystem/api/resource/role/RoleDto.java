package com.vois.bank.BankSystem.api.resource.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {

    private Integer id;
    private String name;

}
