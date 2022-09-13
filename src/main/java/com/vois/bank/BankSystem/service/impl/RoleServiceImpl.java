package com.vois.bank.BankSystem.service.impl;

import com.vois.bank.BankSystem.service.RoleService;
import com.vois.bank.BankSystem.service.dao.RoleDao;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.exception.ResourceAlreadyExistException;
import com.vois.bank.BankSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Role with name " + name + "not found"));
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role with id " + id + "not found"));
    }

    @Override
    public Role addRole(Role role) {
        Optional<Role> role1 = roleDao.findByName(role.getName().name());
        if(role1.isPresent()){
            throw new ResourceAlreadyExistException("Role with name " + role.getName() + " , must be unique");
        }else {
            return roleDao.save(role);
        }
    }
}
