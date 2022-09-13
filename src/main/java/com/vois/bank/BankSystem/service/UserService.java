package com.vois.bank.BankSystem.service;

import com.vois.bank.BankSystem.api.resource.authentication.AuthenticationRequest;
import com.vois.bank.BankSystem.api.resource.authentication.RegisterUser;
import com.vois.bank.BankSystem.service.entity.User;

import java.util.List;

public interface UserService {
    public User getUserById(int id);
    public User getUserByName(String name);
    public User getUserByNameAndPassword(AuthenticationRequest authenticationRequest);
    public List<User> getAllUsers();

    public User addUser(RegisterUser user);
    public String authenticate(AuthenticationRequest authenticationRequest);

}
