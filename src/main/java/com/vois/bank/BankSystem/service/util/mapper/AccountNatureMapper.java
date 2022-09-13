package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.accountnature.AccountNatureDto;
import com.vois.bank.BankSystem.api.resource.accountnature.AccountNatureRequest;
import com.vois.bank.BankSystem.service.entity.AccountNature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {AccountMapper.class})
public interface AccountNatureMapper {

    AccountNatureMapper INSTANCE = Mappers.getMapper(AccountNatureMapper.class);

    AccountNature accountNatureDtoToEntity(AccountNatureDto accountNatureDto);

    AccountNature accountNatureRequestToEntity(AccountNatureRequest accountNatureRequest);

    AccountNatureDto accountNatureToDto(AccountNature accountNature);

    public default List<AccountNatureDto> mapFromListOfAccountNatureToListOfAccountNatureDto(List<AccountNature> accountNatures ) {
        return accountNatures.stream().map(this::accountNatureToDto).collect( Collectors.toList() );
    }

    public default List<AccountNature> mapFromListOfAccountNatureDtoToListOfAccountNature( List<AccountNatureDto> accountNatureDtos ) {
        return accountNatureDtos.stream().map(this::accountNatureDtoToEntity).collect( Collectors.toList() );
    }

}
