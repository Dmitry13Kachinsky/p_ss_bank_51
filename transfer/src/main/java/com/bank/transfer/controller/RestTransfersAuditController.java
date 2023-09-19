package com.bank.transfer.controller;

import com.bank.transfer.entity.Audit;
import com.bank.transfer.service.AuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/transfers-audit")
@Tag(name = "Audit of all transfers", description = "Contains all CRUD-methods for Audit transfers")
public class RestTransfersAuditController {

    private final AuditService auditService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestTransfersAuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/index")
    @Operation(summary = "Gets list of Audit of transfers")
    @ApiResponse(responseCode = "200", description = "Audit-list of transfers have gotten successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get Audit-list of transfers")
    public ResponseEntity<List<Audit>> showAllInfoAboutTransfers() {
        List<Audit> audits = auditService.findAllTransfers();
        logger.log(Level.INFO, "Got the list of Transfers Audit");
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }



}
