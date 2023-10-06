package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import static com.bank.transfer.TestUtils.getTransferAudit_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuditTest {

    @Test
    void testGet() {
        assertEquals(1L, getTransferAudit_1().getId());
        assertEquals("testEntity", getTransferAudit_1().getEntityType());
        assertEquals("testOperation", getTransferAudit_1().getOperationType());
        assertEquals("testCreator", getTransferAudit_1().getCreatedBy());
        assertEquals("testModifier", getTransferAudit_1().getModifiedBy());
        assertEquals(new Timestamp(1L), getTransferAudit_1().getCreatedAt());
        assertEquals(new Timestamp(1L), getTransferAudit_1().getModifiedAt());
        assertEquals("testNewEntityJson", getTransferAudit_1().getNewEntityJson());
        assertEquals("testEntityJson", getTransferAudit_1().getEntityJson());
    }

    @Test
    void toStringTest() {
        assertTrue(getTransferAudit_1().toString().contains("Id=" + getTransferAudit_1().getId()));
    }
}