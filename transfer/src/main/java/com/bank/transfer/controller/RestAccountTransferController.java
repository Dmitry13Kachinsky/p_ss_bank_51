package com.bank.transfer.controller;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.exception.TransferSavingException;
import com.bank.transfer.service.AccountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/account-transfers")
public class RestAccountTransferController {
    private final AccountTransferService accountTransferService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestAccountTransferController(AccountTransferService accountTransferService) {
        this.accountTransferService = accountTransferService;

    }

    @GetMapping("/index")
    public ResponseEntity<List<AccountTransfer>> showAllAccountTransfers() {
        try {
            List<AccountTransfer> accountTransfers = accountTransferService.findAllAccountTransfers();
            logger.log(Level.INFO, "Got the list of Account Transfers.");
            return new ResponseEntity<>(accountTransfers, HttpStatus.OK);
        } catch (TransferNotFoundException e) {
            logger.log(Level.SEVERE, "Bad request to show all Account Transfers. " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewAccountTransfer(@RequestBody AccountTransferDto transferDto) {
        try {
            accountTransferService.addAccountTransfer(transferDto);
            logger.log(Level.INFO, "Account Transfer successfully added.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (TransferSavingException e) {
            logger.log(Level.SEVERE, "Error during saving new Account Transfer. " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<AccountTransfer> getEachAccountTransferById(@PathVariable Long id) {
        try {
            AccountTransfer transfer = accountTransferService.findById(id);
            logger.log(Level.INFO, "Account Transfer with id: " + id + " showed.");
            return new ResponseEntity<>(transfer, HttpStatus.OK);
        } catch (TransferNotFoundException e) {
            logger.log(Level.SEVERE, "Such Account Transfer is not exist. " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/index/{id}")
    public ResponseEntity<HttpStatus> updateAccountTransfer(@PathVariable Long id, @RequestBody AccountTransferDto
            transferDto) {
        try {
            accountTransferService.updateAccountTransfer(id, transferDto);
            logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully updated.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (TransferNotFoundException | TransferSavingException e) {
            logger.log(Level.SEVERE, "Error during updating Account Transfer: check for the correction of" +
                                            "fields. Or maybe such Account Transfer is not exist. " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteAccountTransfer(@PathVariable Long id) {
        try {
            accountTransferService.deleteAccountTransfer(id);
            logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully deleted.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (TransferNotFoundException e) {
            logger.info("Such Account Transfer is not exist. " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
