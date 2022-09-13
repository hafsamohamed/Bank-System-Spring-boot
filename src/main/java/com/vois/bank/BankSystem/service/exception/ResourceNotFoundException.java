package com.vois.bank.BankSystem.service.exception;

public class ResourceNotFoundException extends BankSystemException{
    public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
