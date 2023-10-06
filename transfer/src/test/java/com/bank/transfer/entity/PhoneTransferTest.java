package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getPhoneTransfer_1;
import static com.bank.transfer.TestUtils.getPhoneTransfer_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneTransferTest {

    @Test
    void setAndGetTest() {
        PhoneTransfer transfer = getPhoneTransfer_1();
        transfer.setId(2L);
        assertEquals(2L, transfer.getId());
    }

    @Test
    void toStringTest() {
        assertTrue(getPhoneTransfer_1().toString().contains("Id=" + getPhoneTransfer_1().getId()));
    }

    @Test
    void equalsTest() {
        assertTrue(getPhoneTransfer_3().equals(getPhoneTransfer_1()) && getPhoneTransfer_1().equals(getPhoneTransfer_3()));
    }

    @Test
    void hashCodeTest() {
        assertEquals(getPhoneTransfer_3().hashCode(), getPhoneTransfer_1().hashCode());
    }
}