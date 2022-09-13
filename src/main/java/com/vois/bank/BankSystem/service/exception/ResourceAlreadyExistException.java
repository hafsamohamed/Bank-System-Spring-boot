package com.vois.bank.BankSystem.service.exception;

public class ResourceAlreadyExistException extends BankSystemException{
    public ResourceAlreadyExistException(String message){
        super(message);
    }
    public ResourceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
