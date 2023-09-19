package com.bank.transfer.handler;

import com.bank.transfer.exception.TransferException;
import com.bank.transfer.exception.TransferNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TransferExceptionHandler {

    @ExceptionHandler(value = {TransferNotFoundException.class})
    public ResponseEntity<Object> handleTransferNotFoundException(TransferNotFoundException transferNotFoundException) {
        TransferException transferException = new TransferException(
        transferNotFoundException.getMessage(),
        transferNotFoundException.getCause(),
        HttpStatus.MULTI_STATUS);

        return new ResponseEntity<>(transferException, transferException.getHttpStatus());

    }
}
