package com.profiler.core.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sachindra on 27/07/2015.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactDoesNotExistException extends  RuntimeException {
    public ContactDoesNotExistException(){}

    public ContactDoesNotExistException(Throwable cause){
        super(cause);
    }

    public ContactDoesNotExistException(String message, Throwable cause){
        super(message, cause);
    }

    public ContactDoesNotExistException(String message){
        super(message);
    }
}
