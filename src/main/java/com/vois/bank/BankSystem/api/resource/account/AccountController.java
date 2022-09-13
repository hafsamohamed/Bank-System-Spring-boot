package com.vois.bank.BankSystem.api.resource.account;

import com.vois.bank.BankSystem.service.AccountService;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.util.mapper.AccountMapper;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Manages operations on Account")
@RestController
@RequestMapping(path = "/api/account",  produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final AccountService accountService;
    public static AccountMapper accountMapper = AccountMapper.INSTANCE;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAccount(){
        List<Account> accounts = accountService.getAllAccount();
        List<AccountDto> accountDtos = accountMapper.mapFromListOfAccountToListOfAccountDto(accounts);
        return  new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable("id") String id){
        System.out.println(id);
        Account account = accountService.getAccountByID(id);
        AccountResponse accountResponse = accountMapper.accountToAccountResponse(account);
        return  new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<?> addAccount(@RequestBody AccountNatureRequest accountNatureRequest){
//        AccountNature accountNature = accountNatureService.addAccountNature(accountNatureMapper.accountNatureRequestToEntity(accountNatureRequest));
//        AccountNatureDto accountNatureDto = accountNatureMapper.accountNatureToDto(accountNature);
//        return new ResponseEntity<>(accountNatureDto, HttpStatus.OK);
//
//    }

}
