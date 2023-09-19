package com.bank.transfer.controller;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.service.CardTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/card-transfers")
public class RestCardTransferController {

    private final CardTransferService cardTransferService;
    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestCardTransferController(CardTransferService cardTransferService) {
        this.cardTransferService = cardTransferService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<CardTransfer>> showAllCardTransfers() {
        List<CardTransfer> cardTransfer = cardTransferService.findAllCardTransfers();
        logger.log(Level.INFO, "Got the list of Card Transfers.");
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @PostMapping("/index")
    public ResponseEntity<HttpStatus> addNewCardTransfer(@RequestBody CardTransferDto transferDto) {
        cardTransferService.addCardTransfer(transferDto);
        logger.log(Level.INFO, "Card Transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    public ResponseEntity<CardTransfer> showEachCardTransferById(@PathVariable Long id) {

        CardTransfer cardTransfer = cardTransferService.findById(id);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " showed.");
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    ResponseEntity<HttpStatus> updateCardTransfer(@PathVariable Long id, @RequestBody CardTransferDto transferDto) {

        cardTransferService.updateCardTransfer(id, transferDto);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    public ResponseEntity<HttpStatus> deleteCardTransfer(@PathVariable Long id) {
        cardTransferService.deleteCardTransfer(id);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
