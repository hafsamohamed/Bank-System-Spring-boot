package com.vois.bank.BankSystem.service.exception;

public class ResourceConstraintsViolationException extends BankSystemException{
    public ResourceConstraintsViolationException(String message){
        super(message);
    }
    public ResourceConstraintsViolationException(String message, Throwable cause) {
        super(message, cause);
    }

}
