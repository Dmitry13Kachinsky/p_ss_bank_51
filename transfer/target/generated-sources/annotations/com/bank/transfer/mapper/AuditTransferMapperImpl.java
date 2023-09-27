package com.bank.transfer.mapper;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T13:10:38+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class AuditTransferMapperImpl implements AuditTransferMapper {

    @Override
    public Audit mapToAudit(AuditDto auditDto) {
        if ( auditDto == null ) {
            return null;
        }

        Audit.AuditBuilder audit = Audit.builder();

        audit.entityType( auditDto.getEntityType() );
        audit.operationType( auditDto.getOperationType() );
        audit.createdBy( auditDto.getCreatedBy() );
        audit.modifiedBy( auditDto.getModifiedBy() );
        audit.createdAt( auditDto.getCreatedAt() );
        audit.modifiedAt( auditDto.getModifiedAt() );
        audit.newEntityJson( auditDto.getNewEntityJson() );
        audit.entityJson( auditDto.getEntityJson() );

        return audit.build();
    }

    @Override
    public AuditDto mapToAuditDto(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditDto.AuditDtoBuilder auditDto = AuditDto.builder();

        auditDto.entityType( audit.getEntityType() );
        auditDto.operationType( audit.getOperationType() );
        auditDto.createdBy( audit.getCreatedBy() );
        auditDto.modifiedBy( audit.getModifiedBy() );
        auditDto.createdAt( audit.getCreatedAt() );
        auditDto.modifiedAt( audit.getModifiedAt() );
        auditDto.newEntityJson( audit.getNewEntityJson() );
        auditDto.entityJson( audit.getEntityJson() );

        return auditDto.build();
    }
}
