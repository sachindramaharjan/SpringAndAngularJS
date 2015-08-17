package com.profiler.rest.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sachindra on 27/07/2015.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(Throwable cause){
        super(cause);
    }

    public BadRequestException(){}

}
