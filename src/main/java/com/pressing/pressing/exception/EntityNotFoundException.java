package com.pressing.pressing.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{
    //on recher en bd et il n'existe pas
    @Getter
    private ErrorCode errorCode;

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCode errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}