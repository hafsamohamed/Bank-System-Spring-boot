package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.accountnature.AccountNatureDto;
import com.vois.bank.BankSystem.api.resource.accountnature.AccountNatureRequest;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import com.vois.bank.BankSystem.service.enums.EAccountNature;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T03:36:57+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class AccountNatureMapperImpl implements AccountNatureMapper {

    @Override
    public AccountNature accountNatureDtoToEntity(AccountNatureDto accountNatureDto) {
        if ( accountNatureDto == null ) {
            return null;
        }

        AccountNature accountNature = new AccountNature();

        accountNature.setId( accountNatureDto.getId() );
        if ( accountNatureDto.getNature() != null ) {
            accountNature.setNature( Enum.valueOf( EAccountNature.class, accountNatureDto.getNature() ) );
        }

        return accountNature;
    }

    @Override
    public AccountNature accountNatureRequestToEntity(AccountNatureRequest accountNatureRequest) {
        if ( accountNatureRequest == null ) {
            return null;
        }

        AccountNature accountNature = new AccountNature();

        if ( accountNatureRequest.getNature() != null ) {
            accountNature.setNature( Enum.valueOf( EAccountNature.class, accountNatureRequest.getNature() ) );
        }

        return accountNature;
    }

    @Override
    public AccountNatureDto accountNatureToDto(AccountNature accountNature) {
        if ( accountNature == null ) {
            return null;
        }

        AccountNatureDto accountNatureDto = new AccountNatureDto();

        accountNatureDto.setId( accountNature.getId() );
        if ( accountNature.getNature() != null ) {
            accountNatureDto.setNature( accountNature.getNature().name() );
        }

        return accountNatureDto;
    }
}
