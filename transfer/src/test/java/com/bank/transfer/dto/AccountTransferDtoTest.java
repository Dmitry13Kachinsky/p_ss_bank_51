package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getAccountTransferDto_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTransferDtoTest {

    @Test
    public void getTest() {
        assertEquals(1L, getAccountTransferDto_1().getAccountNumber());
        assertEquals(1.1, getAccountTransferDto_1().getAmount());
        assertEquals("aaa", getAccountTransferDto_1().getPurpose());
        assertEquals(11L, getAccountTransferDto_1().getAccountDetailsId());
    }
}