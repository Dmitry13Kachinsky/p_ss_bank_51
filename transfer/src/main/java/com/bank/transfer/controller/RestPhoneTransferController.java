package com.bank.transfer.controller;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone-transfers")
public class RestPhoneTransferController {

    private final PhoneTransferService phoneTransferService;

    @Autowired
    public RestPhoneTransferController(PhoneTransferService phoneTransferService) {
        this.phoneTransferService = phoneTransferService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<PhoneTransfer>> showAllPhoneTransfers() {
        return new ResponseEntity<>(phoneTransferService.findAllPhoneTransfers(), HttpStatus.OK);
    }

    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewPhoneTransfer(@RequestBody PhoneTransferDto transferDto) {
        phoneTransferService.addPhoneTransfer(transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<PhoneTransfer> showEachPhoneTransferById(@PathVariable Long id) {
        return new ResponseEntity<>(phoneTransferService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    ResponseEntity<HttpStatus> updatePhoneTransfer(@PathVariable Long id, @RequestBody PhoneTransferDto transferDto) {
        if (phoneTransferService.findById(id) == null)
            throw new TransferNotFoundException("Such Phone Transfer not found");

        phoneTransferService.updatePhoneTransfer(id, transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deletePhoneTransfer(@PathVariable Long id) {
        phoneTransferService.deletePhoneTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
