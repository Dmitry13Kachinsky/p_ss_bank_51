package com.bank.transfer.mapper;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountTransferMapper {
    AccountTransferMapper INSTANCE = Mappers.getMapper(AccountTransferMapper.class);
    AccountTransfer mapToAccountTransfer(AccountTransferDto transferDto);
    AccountTransferDto mapToAccountTransferDto(AccountTransfer transfer);
}
