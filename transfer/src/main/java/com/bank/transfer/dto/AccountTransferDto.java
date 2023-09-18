package com.bank.transfer.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AccountTransferDto {
    Long accountNumber;

    Double amount;

    String purpose;

    Long accountDetailsId;

}
