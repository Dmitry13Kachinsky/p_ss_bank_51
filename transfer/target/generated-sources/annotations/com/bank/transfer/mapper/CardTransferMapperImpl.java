package com.bank.transfer.mapper;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T13:10:38+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class CardTransferMapperImpl implements CardTransferMapper {

    @Override
    public CardTransfer mapToCardTransfer(CardTransferDto transferDto) {
        if ( transferDto == null ) {
            return null;
        }

        CardTransfer.CardTransferBuilder cardTransfer = CardTransfer.builder();

        cardTransfer.cardNumber( transferDto.getCardNumber() );
        cardTransfer.amount( transferDto.getAmount() );
        cardTransfer.purpose( transferDto.getPurpose() );
        cardTransfer.accountDetailsId( transferDto.getAccountDetailsId() );

        return cardTransfer.build();
    }

    @Override
    public CardTransferDto mapToCardTransferDto(CardTransfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        CardTransferDto.CardTransferDtoBuilder cardTransferDto = CardTransferDto.builder();

        cardTransferDto.cardNumber( transfer.getCardNumber() );
        cardTransferDto.amount( transfer.getAmount() );
        cardTransferDto.purpose( transfer.getPurpose() );
        cardTransferDto.accountDetailsId( transfer.getAccountDetailsId() );

        return cardTransferDto.build();
    }
}
