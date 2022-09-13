package com.vois.bank.BankSystem.service.exception;

public class BankSystemException extends RuntimeException{ // generic exception for the system
    public BankSystemException(String message){
        super(message);
    }
    public BankSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
