package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getPhoneTransferDto_1;
import static com.bank.transfer.TestUtils.getPhoneTransferDto_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneTransferDtoTest {

    @Test
    public void setAndGetTest() {
        PhoneTransferDto transferDto = getPhoneTransferDto_1();
        transferDto.setPhoneNumber(2L);
        assertEquals(2L, transferDto.getPhoneNumber());
    }

    @Test
    public void testEquals_Symmetric() {
        assertTrue(getPhoneTransferDto_3().equals(getPhoneTransferDto_1()) && getPhoneTransferDto_1().equals(getPhoneTransferDto_3()));
    }

    @Test
    public void testHashcode_Symmetric() {
        assertEquals(getPhoneTransferDto_3().hashCode(), getPhoneTransferDto_1().hashCode());
    }
}