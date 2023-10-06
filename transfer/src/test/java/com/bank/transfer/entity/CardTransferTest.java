package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getAccountTransfer_1;
import static com.bank.transfer.TestUtils.getCardTransfer_1;
import static org.junit.jupiter.api.Assertions.*;

class CardTransferTest {

    @Test
    void testGet() {
        assertEquals(1L, getAccountTransfer_1().getId());
        assertEquals(1L, getAccountTransfer_1().getAccountNumber());
        assertEquals(1.1, getAccountTransfer_1().getAmount());
        assertEquals("aaa", getAccountTransfer_1().getPurpose());
        assertEquals(11L, getAccountTransfer_1().getAccountDetailsId());
    }

    @Test
    void toStringTest() {
        assertTrue(getCardTransfer_1().toString().contains("Id=" + getCardTransfer_1().getId()));
    }
}