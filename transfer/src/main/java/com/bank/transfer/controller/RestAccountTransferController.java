package com.bank.transfer.controller;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
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

        List<AccountTransfer> accountTransfers = accountTransferService.findAllAccountTransfers();
        logger.log(Level.INFO, "Got the list of Account Transfers.");
        return new ResponseEntity<>(accountTransfers, HttpStatus.OK);
    }


    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewAccountTransfer(@RequestBody AccountTransferDto transferDto) {

        accountTransferService.addAccountTransfer(transferDto);
        logger.log(Level.INFO, "Account Transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<AccountTransfer> showEachAccountTransferById(@PathVariable Long id) {

        AccountTransfer transfer = accountTransferService.findById(id);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " showed.");
        return new ResponseEntity<>(transfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    public ResponseEntity<HttpStatus> updateAccountTransfer(@PathVariable Long id, @RequestBody AccountTransferDto
            transferDto) {

        accountTransferService.updateAccountTransfer(id, transferDto);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteAccountTransfer(@PathVariable Long id) {

        accountTransferService.deleteAccountTransfer(id);
        logger.log(Level.INFO, "Account Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
