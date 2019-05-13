package com.example.demo.exception;
/*
*
* 登陆出错
*
* */

public class LoginException extends  RuntimeException{
    String message;
    public LoginException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
