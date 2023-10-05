package com.bank.transfer.mapper;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T12:23:31+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class PhoneTransferMapperImpl implements PhoneTransferMapper {

    @Override
    public PhoneTransfer mapToPhoneTransfer(PhoneTransferDto transferDto) {
        if ( transferDto == null ) {
            return null;
        }

        PhoneTransfer.PhoneTransferBuilder phoneTransfer = PhoneTransfer.builder();

        phoneTransfer.phoneNumber( transferDto.getPhoneNumber() );
        phoneTransfer.amount( transferDto.getAmount() );
        phoneTransfer.purpose( transferDto.getPurpose() );
        phoneTransfer.accountDetailsId( transferDto.getAccountDetailsId() );

        return phoneTransfer.build();
    }

    @Override
    public PhoneTransferDto mapToPhoneTransferDto(PhoneTransfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        PhoneTransferDto.PhoneTransferDtoBuilder phoneTransferDto = PhoneTransferDto.builder();

        phoneTransferDto.phoneNumber( transfer.getPhoneNumber() );
        phoneTransferDto.amount( transfer.getAmount() );
        phoneTransferDto.purpose( transfer.getPurpose() );
        phoneTransferDto.accountDetailsId( transfer.getAccountDetailsId() );

        return phoneTransferDto.build();
    }
}
