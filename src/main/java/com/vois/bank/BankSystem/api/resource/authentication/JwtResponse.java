package com.vois.bank.BankSystem.api.resource.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JwtResponse implements Serializable {
    private String jwt;
}
