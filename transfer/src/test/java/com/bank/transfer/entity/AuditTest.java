package com.bank.transfer.entity;

import org.junit.jupiter.api.Test;

import static com.bank.transfer.TestUtils.getTransferAudit_1;
import static com.bank.transfer.TestUtils.getTransferAudit_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuditTest {

    @Test
    void getAndSetTest() {
        Audit audit = getTransferAudit_1();
        audit.setId(2L);
        assertEquals(2L, audit.getId());
    }

    @Test
    void toStringTest() {
        assertTrue(getTransferAudit_1().toString().contains("Id=" + getTransferAudit_1().getId()));
    }

    @Test
    void equalsTest() {
        assertTrue(getTransferAudit_3().equals(getTransferAudit_1()) && getTransferAudit_1().equals(getTransferAudit_3()));
    }

    @Test
    void hashCodeTest() {
        assertEquals(getTransferAudit_3().hashCode(), getTransferAudit_1().hashCode());
    }
}