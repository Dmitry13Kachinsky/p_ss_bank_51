package com.bank.transfer.exception;

public class TransferSavingException extends RuntimeException {
    public TransferSavingException(String message) {
        super(message);
    }

    public TransferSavingException(String message, Throwable cause) {
        super(message, cause);
    }
}
