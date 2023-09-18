package com.bank.transfer.exception;


public class TransferNotFoundException extends RuntimeException{
    public TransferNotFoundException(String message) {
        super(message);
    }

    public TransferNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
