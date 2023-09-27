package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.mapper.PhoneTransferMapper;
import com.bank.transfer.repository.PhoneTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PhoneTransferServiceImpl implements PhoneTransferService {

    private final PhoneTransferRepository phoneTransferRepository;
    private final PhoneTransferMapper mapper;


    @Autowired
    public PhoneTransferServiceImpl(PhoneTransferRepository phoneTransferRepository) {
        this.phoneTransferRepository = phoneTransferRepository;
        this.mapper = PhoneTransferMapper.INSTANCE;
    }

    @Override
    public List<PhoneTransferDto> findAllPhoneTransfers() {

        return phoneTransferRepository.findAll().stream()
                .map(mapper::mapToPhoneTransferDto).collect(Collectors.toList());
    }

    public PhoneTransferDto findById(Long id) {

        return mapper.mapToPhoneTransferDto(phoneTransferRepository.findById(id)
                .orElseThrow(() -> new TransferNotFoundException("Such phone transfer does not exist")));
    }

    @Override
    @Transactional
    public Long addPhoneTransfer(PhoneTransferDto transferDto) {
        PhoneTransfer transfer = mapper.mapToPhoneTransfer(transferDto);
        return phoneTransferRepository.save(transfer).getId();
    }

    @Override
    @Transactional
    public void updatePhoneTransfer(Long id, PhoneTransferDto transferDto) {
        PhoneTransfer transfer = mapper.mapToPhoneTransfer(transferDto);
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
}
