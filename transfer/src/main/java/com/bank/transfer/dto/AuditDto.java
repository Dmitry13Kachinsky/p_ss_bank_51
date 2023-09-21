package com.bank.transfer.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AuditDto {

    String entityType;
    String operationType;
    String createdBy;
    String modifiedBy;
    Timestamp createdAt;
    Timestamp modifiedAt;
    String newEntityJson;
    String entityJson;
}
