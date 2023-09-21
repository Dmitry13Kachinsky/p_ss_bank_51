package com.bank.transfer.mapper;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import org.springframework.stereotype.Service;

@Service
public class CardTransferMapper {
    public static CardTransfer mapToCardTransfer(CardTransferDto transferDto) {
        return CardTransfer.builder()
                .cardNumber(transferDto.getCardNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();
    }

    public static CardTransferDto mapToCardTransferDto(CardTransfer transfer) {
        return CardTransferDto.builder()
                .cardNumber(transfer.getCardNumber())
                .amount(transfer.getAmount())
                .purpose(transfer.getPurpose())
                .accountDetailsId(transfer.getAccountDetailsId())
                .build();
    }
}
