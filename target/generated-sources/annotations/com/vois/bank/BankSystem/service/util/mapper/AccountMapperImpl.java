package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.account.AccountDto;
import com.vois.bank.BankSystem.api.resource.account.AccountResponse;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T03:36:57+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account accountDtoToEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setBalance( accountDto.getBalance() );
        account.setUser( accountDto.getUser() );
        account.setAccountNature( accountDto.getAccountNature() );
        List<Transaction> list = accountDto.getFromTransactions();
        if ( list != null ) {
            account.setFromTransactions( new ArrayList<Transaction>( list ) );
        }

        return account;
    }

    @Override
    public AccountDto accountToDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setBalance( account.getBalance() );
        accountDto.setUser( account.getUser() );
        accountDto.setAccountNature( account.getAccountNature() );
        List<Transaction> list = account.getFromTransactions();
        if ( list != null ) {
            accountDto.setFromTransactions( new ArrayList<Transaction>( list ) );
        }

        return accountDto;
    }

    @Override
    public AccountResponse accountToAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId( account.getId() );
        accountResponse.setBalance( account.getBalance() );
        accountResponse.setUser( account.getUser() );
        accountResponse.setAccountNature( account.getAccountNature() );
        List<Transaction> list = account.getFromTransactions();
        if ( list != null ) {
            accountResponse.setFromTransactions( new ArrayList<Transaction>( list ) );
        }

        return accountResponse;
    }
}
