package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.account.AccountDto;
import com.vois.bank.BankSystem.api.resource.account.AccountResponse;
import com.vois.bank.BankSystem.api.resource.user.UserDto;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = { UserMapper.class, TransactionMapper.class, AccountMapper.class })
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountDtoToEntity(AccountDto accountDto);

    AccountDto accountToDto(Account account);
    AccountResponse accountToAccountResponse(Account account);

    public default List<AccountDto> mapFromListOfAccountToListOfAccountDto(List<Account> accounts ) {
        return accounts.stream().map(this::accountToDto).collect( Collectors.toList() );
    }

    public default List<Account> mapFromListOfAccountDtoToListOfAccount( List<AccountDto> accountDtos ) {
        return accountDtos.stream().map(this::accountDtoToEntity).collect( Collectors.toList() );
    }
}
