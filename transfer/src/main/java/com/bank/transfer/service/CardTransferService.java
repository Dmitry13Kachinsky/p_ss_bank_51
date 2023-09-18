package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;

import java.util.List;


public interface CardTransferService {

    List<CardTransfer> findAllCardTransfers();

    CardTransfer findById(Long id);

    Long addCardTransfer(CardTransferDto transferDto);

    void updateCardTransfer(Long id, CardTransferDto transferDto);

    void deleteCardTransfer(Long id);
}
