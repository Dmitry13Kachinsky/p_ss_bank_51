package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;

import java.util.List;


public interface AccountTransferService {
    List<AccountTransfer> findAllAccountTransfers();

    AccountTransfer findById(Long id);

    Long addAccountTransfer(AccountTransferDto transferDto);

    void updateAccountTransfer(Long id, AccountTransferDto transferDto);

    void deleteAccountTransfer(Long id);

}
