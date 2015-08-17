package com.profiler.rest.exeception;

/**
 * Created by sachindra on 27/07/2015.
 */
public class ForbiddenException extends RuntimeException {

    public ForbiddenException(){}

    public ForbiddenException(Throwable cause){
        super(cause);
    }
}
