package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;

import java.util.List;


public interface AccountTransferService {
    List<AccountTransferDto> findAllAccountTransfers();

    AccountTransferDto findById(Long id);

    Long addAccountTransfer(AccountTransferDto transferDto);

    void updateAccountTransfer(Long id, AccountTransferDto transferDto);

    void deleteAccountTransfer(Long id);

}
