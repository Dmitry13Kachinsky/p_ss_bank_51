package com.bank.transfer.service;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.mapper.AuditTransferMapper;
import com.bank.transfer.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final AuditTransferMapper auditTransferMapper;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository, AuditTransferMapper auditTransferMapper) {
        this.auditRepository = auditRepository;
        this.auditTransferMapper = auditTransferMapper;
    }

    @Override
    public List<AuditDto> findAllTransfers() {

        return auditRepository.findAll().stream().map(AuditTransferMapper::mapToAuditDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuditDto findById(Long id) {
        return AuditTransferMapper.mapToAuditDto(auditRepository.findById(id).orElseThrow(()
                -> new TransferNotFoundException("Note in Audit not found")));
    }

    @Override
    @Transactional
    public Long addTransferAudit(AuditDto auditDto) {
        Audit audit = AuditTransferMapper.mapToAudit(auditDto);
        return auditRepository.save(audit).getId();
    }

    @Override
    @Transactional
    public void updateTransferAudit(Long id, AuditDto auditDto) {
        if (auditRepository.findById(id) == null) {
            throw new TransferNotFoundException("Note in Audit not found");
        }
        Audit audit = AuditTransferMapper.mapToAudit(auditDto);
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
}
