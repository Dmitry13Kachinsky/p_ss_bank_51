package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;

import java.util.List;

public interface CardTransferService {

    List<CardTransferDto> findAllCardTransfers();

    CardTransferDto findById(Long id);

    Long addCardTransfer(CardTransferDto transferDto);

    void updateCardTransfer(Long id, CardTransferDto transferDto);

    void deleteCardTransfer(Long id);
}
