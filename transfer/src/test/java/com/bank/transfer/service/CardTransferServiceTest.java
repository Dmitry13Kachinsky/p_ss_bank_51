package com.bank.transfer.service;

import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.CardTransferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static com.bank.transfer.TestUtils.getCardTransferDto_1;
import static com.bank.transfer.TestUtils.getCardTransferDto_2;
import static com.bank.transfer.TestUtils.getCardTransferWithoutId_1;
import static com.bank.transfer.TestUtils.getCardTransfer_1;
import static com.bank.transfer.TestUtils.getCardTransfer_2;
import static com.bank.transfer.TestUtils.getListOfCardTransfers;
import static com.bank.transfer.TestUtils.getListOfCardTransfersDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardTransferServiceTest {
    @Mock
    private CardTransferRepository transferRepository;
    @InjectMocks
    private CardTransferServiceImpl transferService;

    @Test
    void addCardTransfer_shouldSaveCardTransfer() {
        // определяет действия репозитория
        when(transferRepository.save(getCardTransferWithoutId_1()))
                .thenReturn(getCardTransfer_1());
        // сравнивает программируемые действия репозитория и созданный тестовый объект (проверка возвращаемого значения)
        assertEquals(
                getCardTransfer_1().getId(), transferService.addCardTransfer(getCardTransferDto_1()));
        verify(transferRepository, times(1)).save(getCardTransferWithoutId_1());
    }

    @Test
    void findCardTransferById_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.findById(1L));
    }

    @Test
    void findAllCardTransfers_shouldGetTheListOfCardTransfers() {
        when(transferRepository.findAll()).thenReturn(getListOfCardTransfers());
        assertEquals(
                getListOfCardTransfersDto(), transferService.findAllCardTransfers());
        verify(transferRepository, times(1)).findAll();
    }

    @Test
    void findCardTransferById_shouldGetCardTransferById() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getCardTransfer_1()));
        assertEquals(
                getCardTransferDto_1(), transferService.findById(1L));
        verify(transferRepository, times(1)).findById(1L);
    }

    @Test
    void updateCardTransfer_shouldUpdateCardTransfer() {
        when(transferRepository.findById(2L)).thenReturn(Optional.of(getCardTransfer_2()));
        transferService.updateCardTransfer(2L, getCardTransferDto_2());
        verify(transferRepository, times(1)).save(getCardTransfer_2());
    }

    @Test
    void updateCardTransfer_shouldThrowException() {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.updateCardTransfer(1L, getCardTransferDto_1()));
    }

    @Test
    void deleteCardTransfer_shouldDeleteCardTransfer() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getCardTransfer_1()));
        transferService.deleteCardTransfer(getCardTransfer_1().getId());
        verify(transferRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteCardTransfer_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.deleteCardTransfer(1L));
    }

}