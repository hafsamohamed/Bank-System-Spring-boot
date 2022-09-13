package com.vois.bank.BankSystem.persistence.dao.impl;

import com.vois.bank.BankSystem.service.dao.UserDao;
import com.vois.bank.BankSystem.service.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepo userRepo;

    public UserDaoImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public User update(User entity) {
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return userRepo.save(entity);
    }

    @Override
    public Optional<User> findById(Integer integer) {
        return userRepo.findById(integer);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }


    @Override
    public Optional<User> findByUserNameAndPassword(String userName, String password) {
        return userRepo.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}
