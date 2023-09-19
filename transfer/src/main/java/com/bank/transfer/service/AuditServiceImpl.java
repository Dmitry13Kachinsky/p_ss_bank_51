package com.bank.transfer.service;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public List<Audit> findAllTransfers() {
        return auditRepository.findAll();
    }

    @Override
    public Audit findById(Long id) {
        return auditRepository.findById(id).orElseThrow(()
                -> new TransferNotFoundException("Note in Audit not found"));
    }

    @Override
    @Transactional
    public Long addTransferAudit(AuditDto auditDto) {
        Audit audit = mapToAudit(auditDto);
        return auditRepository.save(audit).getId();
    }

    @Override
    @Transactional
    public void updateTransferAudit(Long id, AuditDto auditDto) {
        if (auditRepository.findById(id) == null) {
            throw new TransferNotFoundException("Note in Audit not found");
        }
        Audit audit = mapToAudit(auditDto);
        audit.setId(id);
        auditRepository.save(audit);
    }

    @Override
    @Transactional
    public void deleteTransferAudit(Long id) {
        if (auditRepository.findById(id) == null) {
            throw new TransferNotFoundException("Such Account Transfer does not exist!");
        }
        auditRepository.deleteById(id);

    }

    private Audit mapToAudit(AuditDto auditDto) {
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
}
