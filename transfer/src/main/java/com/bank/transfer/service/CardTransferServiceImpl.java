package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.CardTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CardTransferServiceImpl implements CardTransferService {

    private CardTransferRepository cardTransferRepository;

    @Autowired
    public CardTransferServiceImpl(CardTransferRepository cardTransferRepository) {
        this.cardTransferRepository = cardTransferRepository;
    }


    @Override
    public List<CardTransfer> findAllCardTransfers() {
        return cardTransferRepository.findAll();
    }

    @Override
    public CardTransfer findById(Long id) {
        return cardTransferRepository.findById(id).orElseThrow(()
                -> new TransferNotFoundException("Card Transfer not found!"));

    }

    @Override
    @Transactional
    public Long addCardTransfer(CardTransferDto transferDto) {
        CardTransfer transfer = mapToCardTransfer(transferDto);
        return cardTransferRepository.save(transfer).getId();
    }

    @Override
    @Transactional
    public void updateCardTransfer(Long id, CardTransferDto transferDto) {
        CardTransfer transfer = mapToCardTransfer(transferDto);
        transfer.setId(id);
        cardTransferRepository.save(transfer);

    }

    @Override
    @Transactional
    public void deleteCardTransfer(Long id) {
        if (cardTransferRepository.findById(id) == null) {
            throw new TransferNotFoundException("Such card transfer does not exist");
        }
        cardTransferRepository.deleteById(id);

    }

    private CardTransfer mapToCardTransfer(CardTransferDto transferDto) {
        return CardTransfer.builder()
                .cardNumber(transferDto.getCardNumber())
                .amount(transferDto.getAmount())
                .purpose(transferDto.getPurpose())
                .accountDetailsId(transferDto.getAccountDetailsId())
                .build();
    }
}
