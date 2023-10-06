package com.bank.transfer.controller;

import com.bank.transfer.service.CardTransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.logging.Level;
import java.util.logging.Logger;
import static com.bank.transfer.TestUtils.getCardTransferDto_1;
import static com.bank.transfer.TestUtils.getCardTransfer_1;
import static com.bank.transfer.TestUtils.getListOfCardTransfersDto;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestCardTransferControllerTest {
    @InjectMocks
    RestCardTransferController controller;
    @Mock
    private CardTransferService service;
    @Mock
    private Logger logger;

    @Test
    void showAllCardTransfers_shouldShowTheListOfCardTransfers() {
        when(service.findAllCardTransfers()).thenReturn(getListOfCardTransfersDto());
        controller.showAllCardTransfers();
        verify(service, times(1)).findAllCardTransfers();
    }

    @Test
    void addNewCardTransfer_shouldAddNewCardTransfer() {
        controller.addNewCardTransfer(getCardTransferDto_1());
        verify(service, times(1)).addCardTransfer(getCardTransferDto_1());
    }

    @Test
    void showEachCardTransferById_shouldShowEachCardTransferById() {
        when(service.findById(getCardTransfer_1().getId())).thenReturn(getCardTransferDto_1());
        controller.showEachCardTransferById(getCardTransfer_1().getId());
        verify(service, times(1)).findById(getCardTransfer_1().getId());
    }

    @Test
    void updateCardTransfer_shouldUpdateCardTransfer() {
        controller.updateCardTransfer(getCardTransfer_1().getId(), getCardTransferDto_1());
        verify(service, times(1)).updateCardTransfer(getCardTransfer_1().getId(), getCardTransferDto_1());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }

    @Test
    void deleteCardTransfer_shouldDeleteCardTransfer() {
        controller.deleteCardTransfer(getCardTransfer_1().getId());
        verify(service, times(1)).deleteCardTransfer(getCardTransfer_1().getId());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }
}