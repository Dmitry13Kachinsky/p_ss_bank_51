package com.bank.transfer.controller;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.service.AccountTransferService;
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
@RequestMapping("/account-transfers")
@Tag(name = "Account transfers", description = "Contains all CRUD-methods for Account transfers")
public class RestAccountTransferController {
    private final AccountTransferService accountTransferService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestAccountTransferController(AccountTransferService accountTransferService) {
        this.accountTransferService = accountTransferService;

    }

    @GetMapping("/index")
    @Operation(summary = "Gets list of all Account transfers")
    @ApiResponse(responseCode = "200", description = "The list of all Account transfers have gotten successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get all Account transfers")
    public ResponseEntity<List<AccountTransferDto>> showAllAccountTransfers() {

        List<AccountTransferDto> accountTransfers = accountTransferService.findAllAccountTransfers();
        logger.log(Level.INFO, "Got the list of Account transfers.");
        return new ResponseEntity<>(accountTransfers, HttpStatus.OK);
    }


    @PostMapping("/index")
    @Operation(summary = "Adds new Account transfer")
    @ApiResponse(responseCode = "200", description = "Account transfer was added successful")
    @ApiResponse(responseCode = "404", description = "Bad request for adding new Account transfer")
    public ResponseEntity<HttpStatus> addNewAccountTransfer(@RequestBody AccountTransferDto transferDto) {

        accountTransferService.addAccountTransfer(transferDto);
        logger.log(Level.INFO, "Account transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    @Operation(summary = "Shows Account transfer by id")
    @ApiResponse(responseCode = "200", description = "Account transfers have been showed successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get Account transfer by id")
    public ResponseEntity<AccountTransferDto> showEachAccountTransferById(@PathVariable Long id) {

        AccountTransferDto transfer = accountTransferService.findById(id);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " showed.");
        return new ResponseEntity<>(transfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    @Operation(summary = "Updates Account transfer by id")
    @ApiResponse(responseCode = "200", description = "Account transfer have been updated successful")
    @ApiResponse(responseCode = "404", description = "Bad request to update Account transfer by id")
    public ResponseEntity<HttpStatus> updateAccountTransfer(@PathVariable Long id, @RequestBody AccountTransferDto
            transferDto) {

        accountTransferService.updateAccountTransfer(id, transferDto);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    @Operation(summary = "Deletes Account transfer by id")
    @ApiResponse(responseCode = "200", description = "Account transfer have been deleted successful")
    @ApiResponse(responseCode = "404", description = "Bad request to delete Account transfer by id")
    public ResponseEntity<HttpStatus> deleteAccountTransfer(@PathVariable Long id) {

        accountTransferService.deleteAccountTransfer(id);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
