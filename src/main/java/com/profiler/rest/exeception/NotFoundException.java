package com.profiler.rest.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sachindra on 27/07/2015.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(){}

    public NotFoundException(Throwable cause){
        super(cause);
    }
}
