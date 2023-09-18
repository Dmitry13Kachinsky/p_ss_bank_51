package com.bank.transfer.controller;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.TransferNotFoundException;
import com.bank.transfer.service.CardTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-transfers")
public class RestCardTransferController {

    private final CardTransferService cardTransferService;

    @Autowired
    public RestCardTransferController(CardTransferService cardTransferService) {
        this.cardTransferService = cardTransferService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<CardTransfer>> showAllCardTransfers() {
        return new ResponseEntity<>(cardTransferService.findAllCardTransfers(), HttpStatus.OK);
    }

    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewCardTransfer(@RequestBody CardTransferDto transferDto) {
        cardTransferService.addCardTransfer(transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<CardTransfer> showEachCardTransferById(@PathVariable Long id) {
        return new ResponseEntity<>(cardTransferService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    ResponseEntity<HttpStatus> updateCardTransfer(@PathVariable Long id, @RequestBody CardTransferDto transferDto) {
        if (cardTransferService.findById(id) == null)
            throw new TransferNotFoundException("Such Card Transfer not found");

        cardTransferService.updateCardTransfer(id, transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteCardTransfer(@PathVariable Long id) {
        cardTransferService.deleteCardTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
