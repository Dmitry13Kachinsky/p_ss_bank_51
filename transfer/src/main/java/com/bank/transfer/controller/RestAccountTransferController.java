package com.bank.transfer.controller;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.service.AccountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-transfers")
public class RestAccountTransferController {
    private final AccountTransferService accountTransferService;

    @Autowired
    public RestAccountTransferController(AccountTransferService accountTransferService) {
        this.accountTransferService = accountTransferService;

    }

    @GetMapping("/index")
    public ResponseEntity<List<AccountTransfer>> showAllAccountTransfers() {
        return new ResponseEntity<>(accountTransferService.findAllAccountTransfers(), HttpStatus.OK);
    }


    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewAccountTransfer(@RequestBody AccountTransferDto transferDto) {
        accountTransferService.addAccountTransfer(transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<AccountTransfer> getEachAccountTransferById(@PathVariable Long id) {
        return new ResponseEntity<>(accountTransferService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    public ResponseEntity<HttpStatus> updateAccountTransfer(@PathVariable Long id, @RequestBody AccountTransferDto transferDto) {
        if (accountTransferService.findById(id) == null)
            throw new TransferNotFoundException("Such Account Transfer not found");

        accountTransferService.updateAccountTransfer(id, transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteAccountTransfer(@PathVariable Long id) {
        accountTransferService.deleteAccountTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
