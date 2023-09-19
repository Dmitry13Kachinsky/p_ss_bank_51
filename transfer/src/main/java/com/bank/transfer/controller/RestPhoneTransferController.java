package com.bank.transfer.controller;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/phone-transfers")
public class RestPhoneTransferController {

    private final PhoneTransferService phoneTransferService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestPhoneTransferController(PhoneTransferService phoneTransferService) {
        this.phoneTransferService = phoneTransferService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<PhoneTransfer>> showAllPhoneTransfers() {
        List<PhoneTransfer> phoneTransfers = phoneTransferService.findAllPhoneTransfers();
        logger.log(Level.INFO, "Got the list of all Phone Transfers");
        return new ResponseEntity<>(phoneTransfers, HttpStatus.OK);
    }

    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewPhoneTransfer(@RequestBody PhoneTransferDto transferDto) {
        phoneTransferService.addPhoneTransfer(transferDto);
        logger.log(Level.INFO, "Phone Transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<PhoneTransfer> showEachPhoneTransferById(@PathVariable Long id) {
        PhoneTransfer phoneTransfer = phoneTransferService.findById(id);
        logger.log(Level.INFO, "Phone transfer with id: " + id + " showed.");
        return new ResponseEntity<>(phoneTransfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    ResponseEntity<HttpStatus> updatePhoneTransfer(@PathVariable Long id, @RequestBody PhoneTransferDto transferDto) {

        phoneTransferService.updatePhoneTransfer(id, transferDto);
        logger.log(Level.INFO, "Phone Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deletePhoneTransfer(@PathVariable Long id) {
        phoneTransferService.deletePhoneTransfer(id);
        logger.log(Level.INFO, "Phone Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
