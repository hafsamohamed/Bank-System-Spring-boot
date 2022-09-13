package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.account.AccountDto;
import com.vois.bank.BankSystem.api.resource.transaction.TransactionDto;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {AccountMapper.class})
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction transactionDtoToEntity(TransactionDto transactionDto);

    TransactionDto transactionToDto(Transaction transaction);

    public default List<TransactionDto> mapFromListOfTransactionToListOfTransactionDto(List<Transaction> transactions ) {
        return transactions.stream().map(this::transactionToDto).collect( Collectors.toList() );
    }

    public default List<Transaction> mapFromListOfTransactionDtoToListOfTransaction( List<TransactionDto> transactionDtos ) {
        return transactionDtos.stream().map(this::transactionDtoToEntity).collect( Collectors.toList() );
    }
}
