package com.vois.bank.BankSystem.api.resource.authentication;


import com.vois.bank.BankSystem.service.UserService;
import com.vois.bank.BankSystem.service.entity.User;
import com.vois.bank.BankSystem.service.util.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    public static UserMapper userMapper = UserMapper.INSTANCE;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "getEmployee",notes = "Get user base on user name and password url='http://localhost:8085/api/login'")
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest) {

        String jwt = userService.authenticate(authenticationRequest);

        return new  ResponseEntity<>(new JwtResponse(jwt), HttpStatus.OK);
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@ApiParam(value = "admin, admin",required = true, example = "admin, admin") @RequestBody RegisterUser registerAccount) {
        System.out.println(registerAccount.getUserName());
        User user = userService.addUser(registerAccount);
        return new ResponseEntity<>(registerAccount, HttpStatus.OK);
    }

}
