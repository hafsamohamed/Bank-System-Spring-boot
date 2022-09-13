package com.vois.bank.BankSystem.service.impl;

import com.vois.bank.BankSystem.api.resource.authentication.AuthenticationRequest;
import com.vois.bank.BankSystem.api.resource.authentication.RegisterUser;
import com.vois.bank.BankSystem.security.util.JwtUtils;
import com.vois.bank.BankSystem.service.dao.AccountDao;
import com.vois.bank.BankSystem.service.dao.AccountNatureDao;
import com.vois.bank.BankSystem.service.dao.RoleDao;
import com.vois.bank.BankSystem.service.dao.UserDao;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.entity.User;
import com.vois.bank.BankSystem.service.UserService;
import com.vois.bank.BankSystem.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final AccountNatureDao accountNatureDao;
    private final AccountDao accountDao;
    private final RoleDao roleDao;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public User getUserById(int id) {
        return userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id" + id + " , not found"));
    }

    @Override
    public User getUserByName(String name) {
        return userDao.findByUserName(name).orElseThrow(()-> new ResourceNotFoundException("User with name " + name + " , not found"));
    }

    @Override
    public User getUserByNameAndPassword(AuthenticationRequest authenticationRequest) {
        return userDao.findByUserNameAndPassword(authenticationRequest.getUserName(), authenticationRequest.getPassword()).orElseThrow(()-> new ResourceNotFoundException("User with name" + authenticationRequest.getUserName() + " , not found"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    @Transactional
    public User addUser(RegisterUser user) {
        AccountNature accountNature = accountNatureDao.findById(user.getAccount_nature_id())
                .orElseThrow(() -> new ResourceNotFoundException("Account Nature with id " + user.getAccount_nature_id() + ",not found"));

        List<Role> roles = user.getRoles_ids().stream().map((e)-> roleDao.findById(e).orElseThrow(()->
                new ResourceNotFoundException("Role with id " + e + ",not found."))).collect(Collectors.toList());

        User newUser = userDao.save(new User(user.getUserName(), encoder.encode(user.getPassword()), roles));
        Account account = new Account(user.getAccount_id(), user.getBalance(), newUser, accountNature);

        accountDao.save(account);

        Optional<User> user1 = userDao.findByUserName(user.getUserName());
        return user1.orElseGet(() -> userDao.save(newUser));
    }

    @Override
    public String authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch ( AuthenticationException e) {
            throw new ResourceNotFoundException("Incorrect username or password", e);
        }
        return jwtUtils.generateJwtToken(authentication);
    }
}
