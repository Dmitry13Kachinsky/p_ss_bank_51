package com.bank.transfer.controller;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.service.PhoneTransferService;
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
@RequestMapping("/phoneTransfers")
@Tag(name = "Phone transfers", description = "Contains all CRUD-methods for Phone transfers")
public class RestPhoneTransferController {

    private final PhoneTransferService phoneTransferService;

    private final Logger logger = Logger.getLogger(RestAccountTransferController.class.getName());

    @Autowired
    public RestPhoneTransferController(PhoneTransferService phoneTransferService) {
        this.phoneTransferService = phoneTransferService;
    }

    @GetMapping("/index")
    @Operation(summary = "Gets list of all Phone transfers")
    @ApiResponse(responseCode = "200", description = "The list of all Phone transfers have gotten successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get all Phone transfers")
    public ResponseEntity<List<PhoneTransferDto>> showAllPhoneTransfers() {
        List<PhoneTransferDto> phoneTransfers = phoneTransferService.findAllPhoneTransfers();
        logger.log(Level.INFO, "Got the list of all Phone Transfers");
        return new ResponseEntity<>(phoneTransfers, HttpStatus.OK);
    }

    @PostMapping("/index")
    @Operation(summary = "Adds new Phone transfer")
    @ApiResponse(responseCode = "200", description = "Phone transfer was added successful")
    @ApiResponse(responseCode = "404", description = "Bad request for adding new Phone transfer")
    public ResponseEntity<HttpStatus> addNewPhoneTransfer(@RequestBody PhoneTransferDto transferDto) {
        phoneTransferService.addPhoneTransfer(transferDto);
        logger.log(Level.INFO, "Phone Transfer successfully added.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index/{id}")
    @Operation(summary = "Shows Phone transfer by id")
    @ApiResponse(responseCode = "200", description = "Phone transfers have been showed successful")
    @ApiResponse(responseCode = "404", description = "Bad request to get Phone transfer by id")
    public ResponseEntity<PhoneTransferDto> showEachPhoneTransferById(@PathVariable Long id) {
        PhoneTransferDto phoneTransfer = phoneTransferService.findById(id);
        logger.log(Level.INFO, "Phone transfer with id: " + id + " showed.");
        return new ResponseEntity<>(phoneTransfer, HttpStatus.OK);
    }

    @PatchMapping("/index/{id}")
    @Operation(summary = "Updates Phone transfer by id")
    @ApiResponse(responseCode = "200", description = "Phone transfer have been updated successful")
    @ApiResponse(responseCode = "404", description = "Bad request to update Phone transfer by id")
    ResponseEntity<HttpStatus> updatePhoneTransfer(@PathVariable Long id, @RequestBody PhoneTransferDto transferDto) {

        phoneTransferService.updatePhoneTransfer(id, transferDto);
        logger.log(Level.INFO, "Phone Transfer with id: " + id + " successfully updated.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/index/{id}")
    @Operation(summary = "Deletes Phone transfer by id")
    @ApiResponse(responseCode = "200", description = "Phone transfer have been deleted successful")
    @ApiResponse(responseCode = "404", description = "Bad request to delete Phone transfer by id")
    public ResponseEntity<HttpStatus> deletePhoneTransfer(@PathVariable Long id) {
        phoneTransferService.deletePhoneTransfer(id);
        logger.log(Level.INFO, "Phone Transfer with id: " + id + " successfully deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
