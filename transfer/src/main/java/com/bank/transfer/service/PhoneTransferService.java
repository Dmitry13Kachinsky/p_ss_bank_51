package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;

import java.util.List;

public interface PhoneTransferService {
    List<PhoneTransfer> findAllPhoneTransfers();

    PhoneTransfer findById(Long id);

    Long addPhoneTransfer(PhoneTransferDto transferDto);

    void updatePhoneTransfer(Long id, PhoneTransferDto transferDto);

    void deletePhoneTransfer(Long id);
}
