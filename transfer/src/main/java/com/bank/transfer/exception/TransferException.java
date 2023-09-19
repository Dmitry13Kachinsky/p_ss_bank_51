package com.bank.transfer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TransferException extends Throwable {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
