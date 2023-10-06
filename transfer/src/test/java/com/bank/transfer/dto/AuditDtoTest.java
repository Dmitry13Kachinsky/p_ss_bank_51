package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;
import static com.bank.transfer.TestUtils.getTransferAuditDto_1;
import static com.bank.transfer.TestUtils.getTransferAuditDto_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuditDtoTest {

    @Test
    public void setAndGetTest() {
        AuditDto auditDto = getTransferAuditDto_1();
        auditDto.setEntityType("testEntity2");
        assertEquals("testEntity2", auditDto.getEntityType());
    }

    @Test
    public void testEquals_Symmetric() {
        assertTrue(getTransferAuditDto_3().equals(getTransferAuditDto_1()) && getTransferAuditDto_3().equals(getTransferAuditDto_1()));
    }

    @Test
    public void testHashcode_Symmetric() {
        assertEquals(getTransferAuditDto_3().hashCode(), getTransferAuditDto_1().hashCode());
    }
}