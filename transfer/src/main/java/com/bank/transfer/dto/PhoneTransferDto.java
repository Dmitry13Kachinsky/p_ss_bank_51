package com.bank.transfer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneTransferDto {

    Long phoneNumber;
    Double amount;
    String purpose;
    Long accountDetailsId;
}
