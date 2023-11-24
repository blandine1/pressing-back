package com.pressing.pressing.exception;

public enum ErrorCode {
    CATENORIE_NOT_FOUND(1200),
    CATENORIE_ALREADY_EXIST(1300),
    PRODUIT_NOT_FOUND(1400),
    PRODUIT_NOT_VALID(1410),
    SERVICE_NOT_FOUND(1500),
    SERVICE_ALREADY_EXIST(1600),
    UTILISATEUR_ALREADY_EXIST(1700),
    UTILISATEUR_NOT_FOUND_EXCEPTION(1800),

    CLIENT_NOT_FOUND_EXCEPTION(1900),
    CLIENT_ALREADY_EXIST(2000),
    CLIENT_PROPERTY_IS_MISSING(2100),



    ROLE_ULREADY_EXIST(1900),
    ROLE_NOT_FOUND_EXCEPTION(2001),
    SERVICE_NOT_VALID(2002);

    private final int code;

     ErrorCode(int code){
        this.code=code;
    }

    public int getCode(){
        return  code;
    }

}
