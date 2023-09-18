package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.AccountTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountTransferServiceImpl implements AccountTransferService {

    private AccountTransferRepository accountTransferRepository;

    @Autowired
    public AccountTransferServiceImpl(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }

    @Override
    @Transactional
    public Long addAccountTransfer(AccountTransferDto transferDto) {
        AccountTransfer transfer = mapToAccountTransfer(transferDto);
        return accountTransferRepository.save(transfer).getId();

    }

    @Override
    public List<AccountTransfer> findAllAccountTransfers() {

        return accountTransferRepository.findAll();
    }

    @Override
    public AccountTransfer findById(Long id) {

        return accountTransferRepository.findById(id).orElseThrow(()
                -> new TransferNotFoundException("Account Transfer not found"));
    }

    @Override
    @Transactional
    public void updateAccountTransfer(Long id, AccountTransferDto transferDto) {
        if (accountTransferRepository.findById(id) == null) {
            throw new TransferNotFoundException("Account Transfer not found");
        }
        AccountTransfer transfer = mapToAccountTransfer(transferDto);
        transfer.setId(id);
        accountTransferRepository.save(transfer);

    }

    @Override
    @Transactional
    public void deleteAccountTransfer(Long id) {
        if (accountTransferRepository.findById(id) == null) {
            throw new TransferNotFoundException("Such Account Transfer does not exist!");
        }
        accountTransferRepository.deleteById(id);

    }

    private AccountTransfer mapToAccountTransfer(AccountTransferDto transferDto) {
        return AccountTransfer.builder()
                .accountNumber(transferDto.getAccountNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();

    }
}
