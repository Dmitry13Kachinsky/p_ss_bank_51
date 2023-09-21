package com.bank.transfer.mapper;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import org.springframework.stereotype.Service;

@Service
public class AuditTransferMapper {

    public static Audit mapToAudit(AuditDto auditDto) {
        return Audit.builder()
                .entityType(auditDto.getEntityType())
                .operationType(auditDto.getOperationType())
                .createdBy(auditDto.getCreatedBy())
                .modifiedBy(auditDto.getModifiedBy())
                .createdAt(auditDto.getCreatedAt())
                .modifiedAt(auditDto.getModifiedAt())
                .newEntityJson(auditDto.getNewEntityJson())
                .entityJson(auditDto.getEntityJson())
                .build();

    }

    public static AuditDto mapToAuditDto(Audit audit) {
        return AuditDto.builder()
                .entityType(audit.getEntityType())
                .operationType(audit.getOperationType())
                .createdBy(audit.getCreatedBy())
                .modifiedBy(audit.getModifiedBy())
                .createdAt(audit.getCreatedAt())
                .modifiedAt(audit.getModifiedAt())
                .newEntityJson(audit.getNewEntityJson())
                .entityJson(audit.getEntityJson())
                .build();
    }
}
