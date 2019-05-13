package com.example.demo.exception;
/*
*
* 权限管理的出错
* */
public class AuthenticationException extends RuntimeException{
    String message;
    public AuthenticationException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
