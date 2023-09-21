package com.bank.transfer.mapper;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.stereotype.Service;

@Service
public class PhoneTransferMapper {

    public static PhoneTransfer mapToPhoneTransfer(PhoneTransferDto transferDto) {
        return PhoneTransfer.builder()
                .phoneNumber(transferDto.getPhoneNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();
    }

    public static PhoneTransferDto mapToPhoneTransferDto(PhoneTransfer transfer) {
        return PhoneTransferDto.builder()
                .phoneNumber(transfer.getPhoneNumber())
                .amount(transfer.getAmount())
                .purpose(transfer.getPurpose())
                .accountDetailsId(transfer.getAccountDetailsId())
                .build();
    }
}
