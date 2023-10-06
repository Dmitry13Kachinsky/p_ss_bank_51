package com.bank.transfer.service;

import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.AuditRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static com.bank.transfer.TestUtils.getListOfTransfersAudit;
import static com.bank.transfer.TestUtils.getListOfTransfersAuditDto;
import static com.bank.transfer.TestUtils.getTransferAuditDto_1;
import static com.bank.transfer.TestUtils.getTransferAuditDto_2;
import static com.bank.transfer.TestUtils.getTransferAuditWithoutId_1;
import static com.bank.transfer.TestUtils.getTransferAudit_1;
import static com.bank.transfer.TestUtils.getTransferAudit_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuditServiceTest {
    @Mock
    private AuditRepository auditRepository;
    @InjectMocks
    private AuditServiceImpl auditService;

    @Test
    void addTransferAudit_shouldSaveTransferAudit() {
        when(auditRepository.save(getTransferAuditWithoutId_1()))
                .thenReturn(getTransferAudit_1());
        assertEquals(
                getTransferAudit_1().getId(), auditService.addTransferAudit(getTransferAuditDto_1()));
        verify(auditRepository, times(1)).save(getTransferAuditWithoutId_1());
    }

    @Test
    void findAuditTransferById_shouldThrowException() throws TransferNotFoundException {
        when(auditRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> auditService.findById(1L));
    }

    @Test
    void findAllTransfersAudit_shouldGetTheListOfTransfersAudit() {
        when(auditRepository.findAll()).thenReturn(getListOfTransfersAudit());
        assertEquals(
                getListOfTransfersAuditDto(), auditService.findAllTransfers());
        verify(auditRepository, times(1)).findAll();
    }

    @Test
    void findTransferAuditById_shouldGetTransferAuditById() {
        when(auditRepository.findById(1L)).thenReturn(Optional.of(getTransferAudit_1()));
        assertEquals(
                getTransferAuditDto_1(), auditService.findById(1L));
        verify(auditRepository, times(1)).findById(1L);
    }

    @Test
    void updateTransferAudit_shouldUpdateTransferAudit() {
        when(auditRepository.findById(2L)).thenReturn(Optional.of(getTransferAudit_2()));
        auditService.updateTransferAudit(2L, getTransferAuditDto_2());
        verify(auditRepository, times(1)).save(getTransferAudit_2());
    }

    @Test
    void updateTransferAudit_shouldThrowException() {
        when(auditRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> auditService.updateTransferAudit(1L, getTransferAuditDto_1()));
    }

    @Test
    void deleteTransferAudit_shouldDeleteTransferAudit() {
        when(auditRepository.findById(1L)).thenReturn(Optional.of(getTransferAudit_1()));
        auditService.deleteTransferAudit(getTransferAudit_1().getId());
        verify(auditRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTransferAudit_shouldThrowException() throws TransferNotFoundException {
        when(auditRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> auditService.deleteTransferAudit(1L));
    }
}
