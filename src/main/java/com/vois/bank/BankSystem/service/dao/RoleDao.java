package com.vois.bank.BankSystem.service.dao;

import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.entity.User;

import java.util.Optional;

public interface RoleDao extends GenericCrudDao<Role, Integer>{

    Optional<Role> findByName(String name);
    Optional<Role> findById(Integer id);



}
