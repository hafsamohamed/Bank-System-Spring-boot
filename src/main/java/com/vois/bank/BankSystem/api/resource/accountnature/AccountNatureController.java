package com.vois.bank.BankSystem.api.resource.accountnature;

import com.vois.bank.BankSystem.service.AccountNatureService;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.util.mapper.AccountNatureMapper;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Manages operations on Account Nature ")
@RestController
@RequestMapping(path = "/api/accountnature",  produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountNatureController {

    private final AccountNatureService accountNatureService;
    public static AccountNatureMapper accountNatureMapper = AccountNatureMapper.INSTANCE;

    public AccountNatureController(AccountNatureService accountNatureService) {
        this.accountNatureService = accountNatureService;
    }

    @GetMapping
    public ResponseEntity<?> getAccountsNature(){
        List<AccountNature> accountNatures = accountNatureService.getAllAccountNature();
        List<AccountNatureDto> accountNatureDtos = accountNatureMapper.mapFromListOfAccountNatureToListOfAccountNatureDto(accountNatures);
        return  new ResponseEntity<>(accountNatureDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountNature(@PathVariable("id") Integer id){
        AccountNature accountNature = accountNatureService.getById(id);
        AccountNatureDto accountNatureDto = accountNatureMapper.accountNatureToDto(accountNature);
        return  new ResponseEntity<>(accountNatureDto, HttpStatus.OK);
    }



}
