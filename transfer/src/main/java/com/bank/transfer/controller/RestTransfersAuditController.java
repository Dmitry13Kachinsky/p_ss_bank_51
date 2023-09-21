package com.bank.transfer.controller;

import com.bank.transfer.dto.AuditDto;
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
@RequestMapping("/transfersAudit")
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
    public ResponseEntity<List<AuditDto>> showAllInfoAboutTransfers() {
        List<AuditDto> audits = auditService.findAllTransfers();
        logger.log(Level.INFO, "Got the list of Transfers Audit");
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @PostMapping("/index")
    @Operation(summary = "Adds new Audit transfer")
    @ApiResponse(responseCode = "200", description = "Audit transfer was added successful")
    @ApiResponse(responseCode = "404", description = "Bad request for adding new Audit of transfer")
    public ResponseEntity<HttpStatus> addNewTransferAuditPost(@RequestBody AuditDto auditDto) {
        auditService.addTransferAudit(auditDto);
        logger.log(Level.INFO, "Audit post successfully added");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    @Operation(summary = "Shows Audit transfer by id")
    @ApiResponse(responseCode = "200", description = "Audit of transfer have been showed successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get Audit of transfer by id")
    public ResponseEntity<AuditDto> showEachTransfersAuditPost(@PathVariable Long id) {
        AuditDto audit = auditService.findById(id);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " showed");
        return new ResponseEntity<>(audit, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    @Operation(summary = "Updates Audit of transfer by id")
    @ApiResponse(responseCode = "200", description = "Audit of transfer have been updated successful")
    @ApiResponse(responseCode = "404", description = "Bad request to update Audit of transfer by id")
    public ResponseEntity<HttpStatus> updateTransferAuditPost(@PathVariable Long id, @RequestBody AuditDto auditDto) {
        auditService.updateTransferAudit(id, auditDto);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " successfully updated");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    @Operation(summary = "Deletes Audit of transfer by id")
    @ApiResponse(responseCode = "200", description = "Audit transfer have been deleted successful")
    @ApiResponse(responseCode = "404", description = "Bad request to delete Audit of transfer by id")
    public ResponseEntity<HttpStatus> deleteTransferAuditPost(@PathVariable Long id) {
        auditService.deleteTransferAudit(id);
        logger.log(Level.INFO, "Transfer Audit post with id: " + id + " successfully deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
