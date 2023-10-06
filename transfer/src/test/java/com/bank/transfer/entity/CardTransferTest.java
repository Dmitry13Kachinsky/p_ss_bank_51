package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getCardTransfer_1;
import static com.bank.transfer.TestUtils.getCardTransfer_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardTransferTest {

    @Test
    void setAndGetTest() {
        CardTransfer transfer = getCardTransfer_1();
        transfer.setId(2L);
        assertEquals(2L, transfer.getId());
    }

    @Test
    void toStringTest() {
        assertTrue(getCardTransfer_1().toString().contains("Id=" + getCardTransfer_1().getId()));
    }

    @Test
    void equalsTest() {
        assertTrue(getCardTransfer_3().equals(getCardTransfer_1()) && getCardTransfer_1().equals(getCardTransfer_3()));
    }

    @Test
    void hashCodeTest() {
        assertEquals(getCardTransfer_3().hashCode(), getCardTransfer_1().hashCode());
    }
}