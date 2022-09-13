package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.transaction.TransactionDto;
import com.vois.bank.BankSystem.service.entity.Transaction;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T03:36:57+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction transactionDtoToEntity(TransactionDto transactionDto) {
        if ( transactionDto == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( transactionDto.getId() );
        transaction.setAmount( transactionDto.getAmount() );
        transaction.setFromAccount( transactionDto.getFromAccount() );
        transaction.setToAccount( transactionDto.getToAccount() );

        return transaction;
    }

    @Override
    public TransactionDto transactionToDto(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId( transaction.getId() );
        transactionDto.setAmount( transaction.getAmount() );
        transactionDto.setFromAccount( transaction.getFromAccount() );
        transactionDto.setToAccount( transaction.getToAccount() );

        return transactionDto;
    }
}
