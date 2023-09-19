package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;

import java.util.List;


public interface AuditService {

    List<Audit> findAllTransfers();

    Audit findById(Long id);

    Long addTransferAudit(AuditDto auditDto);

    void updateTransferAudit(Long id, AuditDto auditDto);

    void deleteTransferAudit(Long id);

}
