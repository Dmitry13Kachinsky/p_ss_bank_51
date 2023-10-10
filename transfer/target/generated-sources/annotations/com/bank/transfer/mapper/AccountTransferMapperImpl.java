package com.bank.transfer.mapper;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T12:03:59+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class AccountTransferMapperImpl implements AccountTransferMapper {

    @Override
    public AccountTransfer mapToAccountTransfer(AccountTransferDto transferDto) {
        if ( transferDto == null ) {
            return null;
        }

        AccountTransfer.AccountTransferBuilder accountTransfer = AccountTransfer.builder();

        accountTransfer.accountNumber( transferDto.getAccountNumber() );
        accountTransfer.amount( transferDto.getAmount() );
        accountTransfer.purpose( transferDto.getPurpose() );
        accountTransfer.accountDetailsId( transferDto.getAccountDetailsId() );

        return accountTransfer.build();
    }

    @Override
    public AccountTransferDto mapToAccountTransferDto(AccountTransfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        AccountTransferDto.AccountTransferDtoBuilder accountTransferDto = AccountTransferDto.builder();

        accountTransferDto.accountNumber( transfer.getAccountNumber() );
        accountTransferDto.amount( transfer.getAmount() );
        accountTransferDto.purpose( transfer.getPurpose() );
        accountTransferDto.accountDetailsId( transfer.getAccountDetailsId() );

        return accountTransferDto.build();
    }
}
