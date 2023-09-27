package com.bank.transfer.mapper;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditTransferMapper {
    AuditTransferMapper INSTANCE = Mappers.getMapper(AuditTransferMapper.class);
    Audit mapToAudit(AuditDto auditDto);
    AuditDto mapToAuditDto(Audit audit);
}
