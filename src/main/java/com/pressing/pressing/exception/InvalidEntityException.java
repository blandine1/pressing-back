package com.pressing.pressing.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    //lors de l'enregistrement cette donnee n'est pas valide
    @Getter
    private ErrorCode errorCode;

    @Getter
    private List<String>error;

    public InvalidEntityException(String message){
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCode errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCode errorCode, List<String>error){
            super(message);
            this.errorCode=errorCode;
            this.error = error;
    }
}
