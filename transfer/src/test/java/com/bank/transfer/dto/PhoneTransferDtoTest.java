package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;

import static com.bank.transfer.TestUtils.getPhoneTransferDto_1;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTransferDtoTest {

    @Test
    public void getTest() {
        assertEquals(1L, getPhoneTransferDto_1().getPhoneNumber());
        assertEquals(1.1, getPhoneTransferDto_1().getAmount());
        assertEquals("aaa", getPhoneTransferDto_1().getPurpose());
        assertEquals(11L, getPhoneTransferDto_1().getAccountDetailsId());
    }
}