package com.bank.transfer.controller;

import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/transfers-audit")
public class RestTransfersAuditController {

    private final AuditService auditService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestTransfersAuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Audit>> showAllInfoAboutTransfers() {
        List<Audit> audits = auditService.findAllTransfers();
        logger.log(Level.INFO, "Got the list of Transfers Audit");
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewTransferAuditPost(@RequestBody AuditDto auditDto) {
        auditService.addTransferAudit(auditDto);
        logger.log(Level.INFO, "Audit post successfully added");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<Audit> showEachTransfersAuditPost (@PathVariable Long id) {
        Audit audit = auditService.findById(id);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " showed");
        return new ResponseEntity<>(audit, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    public ResponseEntity<HttpStatus> updateTransferAuditPost (@PathVariable Long id, @RequestBody AuditDto auditDto) {
        auditService.updateTransferAudit(id, auditDto);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " successfully updated");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteTransferAuditPost (@PathVariable Long id) {
        auditService.deleteTransferAudit(id);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " successfully deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
