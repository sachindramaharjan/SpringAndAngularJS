package com.profiler.core.service.exception;

import com.profiler.core.entity.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sachindra on 27/07/2015.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ContactExistsException extends RuntimeException{

    public ContactExistsException(){}

    public ContactExistsException(Throwable cause){
        super(cause);
    }

    public ContactExistsException(String message, Throwable cause){
        super(message, cause);
    }

    public ContactExistsException(String message){
        super(message);
    }
}
