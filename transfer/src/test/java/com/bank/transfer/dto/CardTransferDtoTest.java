package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getCardTransferDto_1;
import static com.bank.transfer.TestUtils.getCardTransferDto_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardTransferDtoTest {

    @Test
    public void setAndGetTest() {
        CardTransferDto transferDto = getCardTransferDto_1();
        transferDto.setCardNumber(2L);
        assertEquals(2L, transferDto.getCardNumber());
    }

    @Test
    public void testEquals_Symmetric() {
        assertTrue(getCardTransferDto_3().equals(getCardTransferDto_1()) && getCardTransferDto_1().equals(getCardTransferDto_3()));
    }

    @Test
    public void testHashcode_Symmetric() {
        assertEquals(getCardTransferDto_3().hashCode(), getCardTransferDto_1().hashCode());
    }
}