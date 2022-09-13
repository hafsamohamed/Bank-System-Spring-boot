package com.vois.bank.BankSystem.api.resource.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
    private final String jwt;
}
