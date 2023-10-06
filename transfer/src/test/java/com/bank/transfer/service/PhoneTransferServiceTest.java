package com.bank.transfer.service;

import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.PhoneTransferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static com.bank.transfer.TestUtils.getListOfPhoneTransfers;
import static com.bank.transfer.TestUtils.getListOfPhoneTransfersDto;
import static com.bank.transfer.TestUtils.getPhoneTransferDto_1;
import static com.bank.transfer.TestUtils.getPhoneTransferDto_2;
import static com.bank.transfer.TestUtils.getPhoneTransferWithoutId_1;
import static com.bank.transfer.TestUtils.getPhoneTransfer_1;
import static com.bank.transfer.TestUtils.getPhoneTransfer_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhoneTransferServiceTest {
    @Mock
    private PhoneTransferRepository transferRepository;
    @InjectMocks
    private PhoneTransferServiceImpl transferService;

    @Test
    void addPhoneTransfer_shouldSavePhoneTransfer() {
        when(transferRepository.save(getPhoneTransferWithoutId_1()))
                .thenReturn(getPhoneTransfer_1());
        assertEquals(
                getPhoneTransfer_1().getId(), transferService.addPhoneTransfer(getPhoneTransferDto_1()));
        verify(transferRepository, times(1)).save(getPhoneTransferWithoutId_1());
    }

    @Test
    void findPhoneTransferById_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.findById(1L));
    }

    @Test
    void findAllPhoneTransfers_shouldGetTheListOfPhoneTransfers() {
        when(transferRepository.findAll()).thenReturn(getListOfPhoneTransfers());
        assertEquals(
                getListOfPhoneTransfersDto(), transferService.findAllPhoneTransfers());
        verify(transferRepository, times(1)).findAll();
    }

    @Test
    void findPhoneTransferById_shouldGetPhoneTransferById() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getPhoneTransfer_1()));
        assertEquals(
                getPhoneTransferDto_1(), transferService.findById(1L));
        verify(transferRepository, times(1)).findById(1L);
    }

    @Test
    void updatePhoneTransfer_shouldUpdatePhoneTransfer() {
        when(transferRepository.findById(2L)).thenReturn(Optional.of(getPhoneTransfer_2()));
        transferService.updatePhoneTransfer(2L, getPhoneTransferDto_2());
        verify(transferRepository, times(1)).save(getPhoneTransfer_2());
    }

    @Test
    void updatePhoneTransfer_shouldThrowException() {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.updatePhoneTransfer(1L, getPhoneTransferDto_1()));
    }

    @Test
    void deletePhoneTransfer_shouldDeletePhoneTransfer() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getPhoneTransfer_1()));
        transferService.deletePhoneTransfer(getPhoneTransfer_1().getId());
        verify(transferRepository, times(1)).deleteById(1L);
    }

    @Test
    void deletePhoneTransfer_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.deletePhoneTransfer(1L));
    }
}