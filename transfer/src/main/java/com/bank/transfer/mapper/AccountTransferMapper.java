package com.bank.transfer.mapper;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferMapper {
    public static AccountTransfer mapToAccountTransfer(AccountTransferDto transferDto) {
        return AccountTransfer.builder()
                .accountNumber(transferDto.getAccountNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();
    }

    public static AccountTransferDto mapToAccountTransferDto(AccountTransfer transfer) {
        return AccountTransferDto.builder()
                .accountNumber(transfer.getAccountNumber())
                .amount(transfer.getAmount())
                .purpose(transfer.getPurpose())
                .accountDetailsId(transfer.getAccountDetailsId())
                .build();
    }
}
