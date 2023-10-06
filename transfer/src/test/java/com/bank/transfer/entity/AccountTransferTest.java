package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;

import static com.bank.transfer.TestUtils.getAccountTransfer_1;
import static com.bank.transfer.TestUtils.getAccountTransfer_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTransferTest {

    @Test
    void getAndSetTest() {
        AccountTransfer transfer = getAccountTransfer_1();
        transfer.setId(2L);
        assertEquals(2L, transfer.getId());
    }

    @Test
    void toStringTest() {
        assertTrue(getAccountTransfer_1().toString().contains("Id=" + getAccountTransfer_1().getId()));
    }

    @Test
    void equalsTest() {
        assertTrue(getAccountTransfer_3().equals(getAccountTransfer_1()) && getAccountTransfer_1().equals(getAccountTransfer_3()));
    }

    @Test
    void hashCodeTest() {
        assertEquals(getAccountTransfer_3().hashCode(), getAccountTransfer_1().hashCode());
    }
}