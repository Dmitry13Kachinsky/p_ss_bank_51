package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getAccountTransferDto_1;
import static com.bank.transfer.TestUtils.getAccountTransferDto_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTransferDtoTest {

    @Test
    public void setAndGetTest() {
        AccountTransferDto transferDto = getAccountTransferDto_1();
        transferDto.setAccountNumber(2L);
        assertEquals(2L, transferDto.getAccountNumber());
    }

    @Test
    public void testEquals_Symmetric() {
        assertTrue(getAccountTransferDto_3().equals(getAccountTransferDto_1()) && getAccountTransferDto_1().equals(getAccountTransferDto_3()));
    }

    @Test
    public void testHashcode_Symmetric() {
        assertEquals(getAccountTransferDto_3().hashCode(), getAccountTransferDto_1().hashCode());
    }
}