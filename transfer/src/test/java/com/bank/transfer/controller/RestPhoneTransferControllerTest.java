package com.bank.transfer.controller;

import com.bank.transfer.service.PhoneTransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.bank.transfer.TestUtils.getAccountTransfer_1;
import static com.bank.transfer.TestUtils.getListOfPhoneTransfersDto;
import static com.bank.transfer.TestUtils.getPhoneTransferDto_1;
import static com.bank.transfer.TestUtils.getPhoneTransfer_1;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestPhoneTransferControllerTest {
    @InjectMocks
    RestPhoneTransferController controller;
    @Mock
    private PhoneTransferService service;
    @Mock
    private Logger logger;

    @Test
    void showAllPhoneTransfers_shouldShowTheListOfPhoneTransfers() {
        when(service.findAllPhoneTransfers()).thenReturn(getListOfPhoneTransfersDto());
        controller.showAllPhoneTransfers();
        verify(service, times(1)).findAllPhoneTransfers();
    }

    @Test
    void addNewPhoneTransfer_shouldAddNewPhoneTransfer() {
        controller.addNewPhoneTransfer(getPhoneTransferDto_1());
        verify(service, times(1)).addPhoneTransfer(getPhoneTransferDto_1());
    }

    @Test
    void showEachPhoneTransferById_shouldShowEachPhoneTransferById() {
        when(service.findById(getPhoneTransfer_1().getId())).thenReturn(getPhoneTransferDto_1());
        controller.showEachPhoneTransferById(getPhoneTransfer_1().getId());
        verify(service, times(1)).findById(getPhoneTransfer_1().getId());
    }

    @Test
    void updatePhoneTransfer() {
        controller.updatePhoneTransfer(getPhoneTransfer_1().getId(), getPhoneTransferDto_1());
        verify(service, times(1)).updatePhoneTransfer(getPhoneTransfer_1().getId(), getPhoneTransferDto_1());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }

    @Test
    void deletePhoneTransfer() {
        controller.deletePhoneTransfer(getPhoneTransfer_1().getId());
        verify(service, times(1)).deletePhoneTransfer(getAccountTransfer_1().getId());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }
}