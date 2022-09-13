package com.vois.bank.BankSystem.service;

import com.vois.bank.BankSystem.service.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoles();
    public Role getRoleByName(String name);
    public Role getRoleById(Integer id);
    public Role addRole(Role role);
}
