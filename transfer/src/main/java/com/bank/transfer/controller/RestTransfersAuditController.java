package com.bank.transfer.controller;

import com.bank.transfer.entity.Audit;
import com.bank.transfer.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transfers-audit")
public class RestTransfersAuditController {

    private final AuditService auditService;

    @Autowired
    public RestTransfersAuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Audit>> showAllInfoAboutTransfers() {
        return new ResponseEntity<>(auditService.findAllTransfers(), HttpStatus.OK);
    }


}
