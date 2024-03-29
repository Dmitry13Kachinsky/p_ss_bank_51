package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.mapper.CardTransferMapper;
import com.bank.transfer.repository.CardTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CardTransferServiceImpl implements CardTransferService {

    private final CardTransferRepository cardTransferRepository;
    private final CardTransferMapper mapper;

    @Autowired
    public CardTransferServiceImpl(CardTransferRepository cardTransferRepository) {
        this.cardTransferRepository = cardTransferRepository;
        this.mapper = CardTransferMapper.INSTANCE;
    }

    @Override
    public List<CardTransferDto> findAllCardTransfers() {

        return cardTransferRepository.findAll().stream()
                .map(mapper::mapToCardTransferDto).collect(Collectors.toList());
    }

    @Override
    public CardTransferDto findById(Long id) {
        return mapper.mapToCardTransferDto(cardTransferRepository.findById(id)
                .orElseThrow(() -> new TransferNotFoundException("Card Transfer not found!")));
    }

    @Override
    @Transactional
    public Long addCardTransfer(CardTransferDto transferDto) {
        CardTransfer transfer = mapper.mapToCardTransfer(transferDto);
        return cardTransferRepository.save(transfer).getId();
    }

    @Override
    @Transactional
    public void updateCardTransfer(Long id, CardTransferDto transferDto) {
        if (cardTransferRepository.findById(id).isEmpty()) {
            throw new TransferNotFoundException("Card Transfer not found");
        }
        CardTransfer transfer = mapper.mapToCardTransfer(transferDto);
        transfer.setId(id);
        cardTransferRepository.save(transfer);
    }

    @Override
    @Transactional
    public void deleteCardTransfer(Long id) {
        if (cardTransferRepository.findById(id).isEmpty()) {
            throw new TransferNotFoundException("Such card transfer does not exist");
        }
        cardTransferRepository.deleteById(id);
    }
}
