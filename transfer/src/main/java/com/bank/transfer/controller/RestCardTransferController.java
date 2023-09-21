package com.bank.transfer.controller;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.service.CardTransferService;
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
@RequestMapping("/card-transfers")
@Tag(name = "Card transfers", description = "Contains all CRUD-methods for Card transfers")
public class RestCardTransferController {

    private final CardTransferService cardTransferService;
    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestCardTransferController(CardTransferService cardTransferService) {
        this.cardTransferService = cardTransferService;
    }

    @GetMapping("/index")
    @Operation(summary = "Gets list of all Card transfers")
    @ApiResponse(responseCode = "200", description = "The list of all Card transfers have gotten successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get all Card transfers")
    public ResponseEntity<List<CardTransferDto>> showAllCardTransfers() {
        List<CardTransferDto> cardTransfer = cardTransferService.findAllCardTransfers();
        logger.log(Level.INFO, "Got the list of Card Transfers.");
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @PostMapping("/index")
    @Operation(summary = "Adds new Card transfer")
    @ApiResponse(responseCode = "200", description = "Card transfer was added successful")
    @ApiResponse(responseCode = "404", description = "Bad request for adding new Card transfer")
    public ResponseEntity<HttpStatus> addNewCardTransfer(@RequestBody CardTransferDto transferDto) {
        cardTransferService.addCardTransfer(transferDto);
        logger.log(Level.INFO, "Card Transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    @Operation(summary = "Shows Card transfer by id")
    @ApiResponse(responseCode = "200", description = "Card transfers have been successful showed")
    @ApiResponse(responseCode = "404", description = "Bad request to get Card transfer by id")
    public ResponseEntity<CardTransferDto> showEachCardTransferById(@PathVariable Long id) {

        CardTransferDto cardTransfer = cardTransferService.findById(id);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " showed.");
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    @Operation(summary = "Updates Card transfer by id")
    @ApiResponse(responseCode = "200", description = "Card transfer have been updated successful")
    @ApiResponse(responseCode = "404", description = "Bad request to update Card transfer by id")
    ResponseEntity<HttpStatus> updateCardTransfer(@PathVariable Long id, @RequestBody CardTransferDto transferDto) {

        cardTransferService.updateCardTransfer(id, transferDto);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    @Operation(summary = "Deletes Card transfer by id")
    @ApiResponse(responseCode = "200", description = "Card transfer have been deleted successful")
    @ApiResponse(responseCode = "404", description = "Bad request to delete Card transfer by id")
    public ResponseEntity<HttpStatus> deleteCardTransfer(@PathVariable Long id) {
        cardTransferService.deleteCardTransfer(id);
        logger.log(Level.INFO, "Card Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
