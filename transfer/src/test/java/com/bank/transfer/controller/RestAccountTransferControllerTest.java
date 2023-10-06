package com.bank.transfer.controller;

import com.bank.transfer.service.AccountTransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.bank.transfer.TestUtils.getAccountTransferDto_1;
import static com.bank.transfer.TestUtils.getAccountTransfer_1;
import static com.bank.transfer.TestUtils.getListOfAccountTransfersDto;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestAccountTransferControllerTest {
    @Mock
    private AccountTransferService service;
    @Mock
    private Logger logger;
    @InjectMocks
    RestAccountTransferController controller;

    @Test
    void showAllAccountTransfersTest_shouldShowTheListOfAccountTransfers() {
        when(service.findAllAccountTransfers()).thenReturn(getListOfAccountTransfersDto());
        controller.showAllAccountTransfers();
        verify(service, times(1)).findAllAccountTransfers();
    }

    @Test
    void addNewAccountTransferTest_shouldAddNewAccountTransfer() {
        controller.addNewAccountTransfer(getAccountTransferDto_1());
        verify(service, times(1)).addAccountTransfer(getAccountTransferDto_1());
    }

    @Test
    void showEachAccountTransferById_shouldShowEachAccountTransferById() {
        when(service.findById(getAccountTransfer_1().getId())).thenReturn(getAccountTransferDto_1());
        controller.showEachAccountTransferById(getAccountTransfer_1().getId());
        verify(service, times(1)).findById(getAccountTransfer_1().getId());
    }

    @Test
    void updateAccountTransfer_shouldUpdateAccountTransfer() {
        controller.updateAccountTransfer(getAccountTransfer_1().getId(), getAccountTransferDto_1());
        verify(service, times(1)).updateAccountTransfer(getAccountTransfer_1().getId(), getAccountTransferDto_1());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }

    @Test
    void deleteAccountTransfer_shouldDeleteAccountTransfer() {
        controller.deleteAccountTransfer(getAccountTransfer_1().getId());
        verify(service, times(1)).deleteAccountTransfer(getAccountTransfer_1().getId());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }
}