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
    private final AccountTransferMapper mapper;

    @Autowired
    public AccountTransferServiceImpl(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
        this.mapper = AccountTransferMapper.INSTANCE;
    }

    @Override
    @Transactional
    public Long addAccountTransfer(AccountTransferDto transferDto) {
        AccountTransfer transfer = mapper.mapToAccountTransfer(transferDto);
        return accountTransferRepository.save(transfer).getId();
    }

    @Override
    public List<AccountTransferDto> findAllAccountTransfers() {

        return accountTransferRepository.findAll().stream()
                .map(mapper::mapToAccountTransferDto).collect(Collectors.toList());
    }

    @Override
    public AccountTransferDto findById(Long id) {

        return mapper.mapToAccountTransferDto(
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
        AccountTransfer transfer = mapper.mapToAccountTransfer(transferDto);
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
