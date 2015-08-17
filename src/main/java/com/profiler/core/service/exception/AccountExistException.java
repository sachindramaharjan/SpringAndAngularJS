package com.profiler.core.service.exception;

/**
 * Created by sachindra on 27/07/2015.
 */
public class AccountExistException extends RuntimeException {

    public AccountExistException(Throwable cause){
        super(cause);
    }

    public AccountExistException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountExistException(String message){
        super(message);
    }

    public AccountExistException(){}
}
