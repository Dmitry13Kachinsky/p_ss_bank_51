package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;

import static com.bank.transfer.TestUtils.getCardTransfer_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTransferDtoTest {

    @Test
    public void getTest() {
        assertEquals(1L, getCardTransfer_1().getId());
        assertEquals(1L, getCardTransfer_1().getCardNumber());
        assertEquals(1.1, getCardTransfer_1().getAmount());
        assertEquals("aaa", getCardTransfer_1().getPurpose());
        assertEquals(11L, getCardTransfer_1().getAccountDetailsId());
    }
}