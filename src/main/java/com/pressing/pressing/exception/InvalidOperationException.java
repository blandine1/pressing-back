package com.pressing.pressing.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException{
    //on recher en bd et il n'existe pas
    @Getter
    private ErrorCode errorCode;

    public InvalidOperationException(String message){
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidOperationException(String message, Throwable cause, ErrorCode errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidOperationException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
