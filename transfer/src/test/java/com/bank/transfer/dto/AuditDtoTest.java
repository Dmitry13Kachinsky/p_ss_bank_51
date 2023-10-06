package com.bank.transfer.dto;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import static com.bank.transfer.TestUtils.getTransferAuditDto_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuditDtoTest {

    @Test
    public void getTest() {
        assertEquals("testEntity", getTransferAuditDto_1().getEntityType());
        assertEquals("testOperation", getTransferAuditDto_1().getOperationType());
        assertEquals("testCreator", getTransferAuditDto_1().getCreatedBy());
        assertEquals("testModifier", getTransferAuditDto_1().getModifiedBy());
        assertEquals(new Timestamp(1L), getTransferAuditDto_1().getCreatedAt());
        assertEquals(new Timestamp(1L), getTransferAuditDto_1().getModifiedAt());
        assertEquals("testNewEntityJson", getTransferAuditDto_1().getNewEntityJson());
        assertEquals("testEntityJson", getTransferAuditDto_1().getEntityJson());
    }
}