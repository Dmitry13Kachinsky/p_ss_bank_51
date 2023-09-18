package com.bank.transfer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardTransferDto {
    Long cardNumber;

    Double amount;

    String purpose;

    Long accountDetailsId;
}
