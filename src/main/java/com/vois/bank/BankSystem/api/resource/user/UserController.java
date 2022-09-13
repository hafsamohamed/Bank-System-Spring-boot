package com.vois.bank.BankSystem.api.resource.user;

import com.vois.bank.BankSystem.api.resource.authentication.RegisterUser;
import com.vois.bank.BankSystem.service.UserService;
import com.vois.bank.BankSystem.service.entity.User;
import com.vois.bank.BankSystem.service.util.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Manages operations on User ")
@RestController
@RequestMapping(path = "/api/users",  produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public static UserMapper userMapper = UserMapper.INSTANCE;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = userMapper.mapFromListOfUserToListOfUserDto(users);
        return  new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    //  TODO : move business to business layer

//    @ApiOperation(value = "addUser",notes = "Get user base on user name and password url='http://localhost:8085/api/users/register'")
//    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> addUser(@ApiParam(value = "admin, admin",required = true, example = "admin, admin") @RequestBody RegisterUser registerAccount) {
//        User user = userService.addUser(registerAccount);
//        return new ResponseEntity<>(registerAccount, HttpStatus.OK);
//    }


}
