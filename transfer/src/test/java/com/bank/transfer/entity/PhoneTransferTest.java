package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getPhoneTransfer_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneTransferTest {

    @Test
    void testGet() {
        assertEquals(1L, getPhoneTransfer_1().getId());
        assertEquals(1L, getPhoneTransfer_1().getPhoneNumber());
        assertEquals(1.1, getPhoneTransfer_1().getAmount());
        assertEquals("aaa", getPhoneTransfer_1().getPurpose());
        assertEquals(11L, getPhoneTransfer_1().getAccountDetailsId());
    }

    @Test
    void toStringTest() {
        assertTrue(getPhoneTransfer_1().toString().contains("Id=" + getPhoneTransfer_1().getId()));
    }
}