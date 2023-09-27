package com.bank.transfer.mapper;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneTransferMapper {
    PhoneTransferMapper INSTANCE = Mappers.getMapper(PhoneTransferMapper.class);
    PhoneTransfer mapToPhoneTransfer(PhoneTransferDto transferDto);
    PhoneTransferDto mapToPhoneTransferDto(PhoneTransfer transfer);
}
