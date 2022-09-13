package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.dao.RoleDao;
import com.vois.bank.BankSystem.service.dao.UserDao;
import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final RoleRepo roleRepo;

    public RoleDaoImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role save(Role entity) {
        return roleRepo.save(entity);
    }

    @Override
    public Role update(Role entity) {
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return roleRepo.save(entity);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public Optional<Role> findById(Integer integer) {
        return roleRepo.findById(integer);
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }


}
