package com.profiler.rest.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sachindra on 27/07/2015.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(){}

    public ConflictException(Throwable cause){
        super(cause);
    }
}
