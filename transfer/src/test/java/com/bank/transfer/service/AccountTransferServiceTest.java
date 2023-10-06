package com.bank.transfer.service;

import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.AccountTransferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static com.bank.transfer.TestUtils.getAccountTransferDto_1;
import static com.bank.transfer.TestUtils.getAccountTransferDto_2;
import static com.bank.transfer.TestUtils.getAccountTransferWithoutId_1;
import static com.bank.transfer.TestUtils.getAccountTransfer_1;
import static com.bank.transfer.TestUtils.getAccountTransfer_2;
import static com.bank.transfer.TestUtils.getListOfAccountTransfers;
import static com.bank.transfer.TestUtils.getListOfAccountTransfersDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTransferServiceTest {
    @Mock
    private AccountTransferRepository transferRepository;
    @InjectMocks
    private AccountTransferServiceImpl transferService;

    @Test
    void addAccountTransfer_shouldSaveAccountTransfer() {
        // определяет действия репозитория
        when(transferRepository.save(getAccountTransferWithoutId_1()))
                .thenReturn(getAccountTransfer_1());
        // сравнивает программируемые действия репозитория и созданный тестовый объект (проверка возвращаемого значения)
        assertEquals(
                getAccountTransfer_1().getId(), transferService.addAccountTransfer(getAccountTransferDto_1()));
        verify(transferRepository, times(1)).save(getAccountTransferWithoutId_1());
    }

    @Test
    void findAccountTransferById_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.findById(1L));
    }

    @Test
    void findAllAccountTransfers_shouldGetTheListOfAccountTransfers() {
        when(transferRepository.findAll()).thenReturn(getListOfAccountTransfers());
        assertEquals(
                getListOfAccountTransfersDto(), transferService.findAllAccountTransfers());
        verify(transferRepository, times(1)).findAll();
    }

    @Test
    void findAccountTransferById_shouldGetAccountTransferById() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getAccountTransfer_1()));
        assertEquals(
                getAccountTransferDto_1(), transferService.findById(1L));
        verify(transferRepository, times(1)).findById(1L);
    }

    @Test
    void updateAccountTransfer_shouldUpdateAccountTransfer() {
        when(transferRepository.findById(2L)).thenReturn(Optional.of(getAccountTransfer_2()));
        transferService.updateAccountTransfer(2L, getAccountTransferDto_2());
        verify(transferRepository, times(1)).save(getAccountTransfer_2());
    }

    @Test
    void updateAccountTransfer_shouldThrowException() {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.updateAccountTransfer(1L, getAccountTransferDto_1()));
    }

    @Test
    void deleteAccountTransfer_shouldDeleteAccountTransfer() {
        when(transferRepository.findById(1L)).thenReturn(Optional.of(getAccountTransfer_1()));
        transferService.deleteAccountTransfer(getAccountTransfer_1().getId());
        verify(transferRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteAccountTransfer_shouldThrowException() throws TransferNotFoundException {
        when(transferRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TransferNotFoundException.class, () -> transferService.deleteAccountTransfer(1L));
    }
}
