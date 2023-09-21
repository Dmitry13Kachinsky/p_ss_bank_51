package com.bank.transfer.service;

import com.bank.transfer.dto.AuditDto;

import java.util.List;

public interface AuditService {

    List<AuditDto> findAllTransfers();

    AuditDto findById(Long id);

    Long addTransferAudit(AuditDto auditDto);

    void updateTransferAudit(Long id, AuditDto auditDto);

    void deleteTransferAudit(Long id);

}
