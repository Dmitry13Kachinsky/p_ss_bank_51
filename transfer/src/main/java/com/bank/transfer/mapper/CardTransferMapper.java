package com.bank.transfer.mapper;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardTransferMapper {
    CardTransferMapper INSTANCE = Mappers.getMapper(CardTransferMapper.class);
    CardTransfer mapToCardTransfer(CardTransferDto transferDto);
    CardTransferDto mapToCardTransferDto(CardTransfer transfer);
}
