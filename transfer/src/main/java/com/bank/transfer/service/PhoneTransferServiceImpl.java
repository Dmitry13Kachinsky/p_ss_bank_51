package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.PhoneTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PhoneTransferServiceImpl implements PhoneTransferService {

    private PhoneTransferRepository phoneTransferRepository;

    @Autowired
    public PhoneTransferServiceImpl(PhoneTransferRepository phoneTransferRepository) {
        this.phoneTransferRepository = phoneTransferRepository;
    }


    @Override
    public List<PhoneTransfer> findAllPhoneTransfers() {
        return phoneTransferRepository.findAll();
    }

    public PhoneTransfer findById(Long id) {
        return phoneTransferRepository.findById(id).orElseThrow(()
                -> new TransferNotFoundException("Phone Transfer not found"));
    }

    @Override
    @Transactional
    public Long addPhoneTransfer(PhoneTransferDto transferDto) {
        PhoneTransfer transfer = mapToPhoneTransfer(transferDto);
        return phoneTransferRepository.save(transfer).getId();
    }

    @Override
    @Transactional
    public void updatePhoneTransfer(Long id, PhoneTransferDto transferDto) {
        PhoneTransfer transfer = mapToPhoneTransfer(transferDto);
        transfer.setId(id);
        phoneTransferRepository.save(transfer);

    }

    @Override
    @Transactional
    public void deletePhoneTransfer(Long id) {
        if (phoneTransferRepository.findById(id) == null) {
            throw new TransferNotFoundException("Such phone transfer does not exist");
        }
        phoneTransferRepository.deleteById(id);

    }

    private PhoneTransfer mapToPhoneTransfer(PhoneTransferDto transferDto) {
        return PhoneTransfer.builder()
                .phoneNumber(transferDto.getPhoneNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();
    }
}
