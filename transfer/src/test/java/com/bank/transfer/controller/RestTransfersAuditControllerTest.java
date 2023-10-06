package com.bank.transfer.controller;

import com.bank.transfer.service.AuditService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.bank.transfer.TestUtils.getListOfTransfersAuditDto;
import static com.bank.transfer.TestUtils.getTransferAuditDto_1;
import static com.bank.transfer.TestUtils.getTransferAudit_1;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestTransfersAuditControllerTest {
    @InjectMocks
    RestTransfersAuditController controller;
    @Mock
    private AuditService service;
    @Mock
    private Logger logger;

    @Test
    void showAllInfoAboutTransfers_shouldShowTheListOfTransferAudit() {
        when(service.findAllTransfers()).thenReturn(getListOfTransfersAuditDto());
        controller.showAllInfoAboutTransfers();
        verify(service, times(1)).findAllTransfers();
    }

    @Test
    void addNewTransferAuditPost_shouldAddNewTransferAudit() {
        controller.addNewTransferAuditPost(getTransferAuditDto_1());
        verify(service, times(1)).addTransferAudit(getTransferAuditDto_1());
    }

    @Test
    void showEachTransfersAuditPost_shouldShowEachAuditTransferById() {
        when(service.findById(getTransferAudit_1().getId())).thenReturn(getTransferAuditDto_1());
        controller.showEachTransfersAuditPost(getTransferAudit_1().getId());
        verify(service, times(1)).findById(getTransferAudit_1().getId());
    }

    @Test
    void updateTransferAuditPost_shouldUpdateAuditTransfer() {
        controller.updateTransferAuditPost(getTransferAudit_1().getId(), getTransferAuditDto_1());
        verify(service, times(1)).updateTransferAudit(getTransferAudit_1().getId(), getTransferAuditDto_1());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }

    @Test
    void deleteTransferAuditPost_shouldDeleteAuditTransfer() {
        controller.deleteTransferAuditPost(getTransferAudit_1().getId());
        verify(service, times(1)).deleteTransferAudit(getTransferAudit_1().getId());
        verify(logger, times(0)).log(Level.WARNING, "message");
    }
}