package com.vois.bank.BankSystem.service.dao;

import com.vois.bank.BankSystem.service.entity.User;

import java.util.Optional;

public interface UserDao extends GenericCrudDao<User, Integer>{

    Optional<User> findByUserNameAndPassword(String userName, String password);
    Optional<User> findByUserName(String userName);



}
