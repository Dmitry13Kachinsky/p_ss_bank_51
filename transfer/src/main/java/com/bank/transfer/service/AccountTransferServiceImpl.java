package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.mapper.AccountTransferMapper;
import com.bank.transfer.repository.AccountTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AccountTransferServiceImpl implements AccountTransferService {

    private final AccountTransferRepository accountTransferRepository;
    private final AccountTransferMapper accountTransferMapper;

    @Autowired
    public AccountTransferServiceImpl(AccountTransferRepository accountTransferRepository, AccountTransferMapper accountTransferMapper) {
        this.accountTransferRepository = accountTransferRepository;
        this.accountTransferMapper = accountTransferMapper;
    }


    @Override
    @Transactional
    public Long addAccountTransfer(AccountTransferDto transferDto) {
        AccountTransfer transfer = accountTransferMapper.mapToAccountTransfer(transferDto);
        return accountTransferRepository.save(transfer).getId();

    }

    @Override
    public List<AccountTransferDto> findAllAccountTransfers() {

        return accountTransferRepository.findAll().stream()
                .map(AccountTransferMapper::mapToAccountTransferDto).collect(Collectors.toList());
    }

    @Override
    public AccountTransferDto findById(Long id) {

        return AccountTransferMapper.mapToAccountTransferDto(
                accountTransferRepository.findById(id)
                .orElseThrow(()
                -> new TransferNotFoundException("Account Transfer not found")));
    }

    @Override
    @Transactional
    public void updateAccountTransfer(Long id, AccountTransferDto transferDto) {
        if (accountTransferRepository.findById(id) == null) {
            throw new TransferNotFoundException("Account Transfer not found");
        }
        AccountTransfer transfer = accountTransferMapper.mapToAccountTransfer(transferDto);
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


}
