package com.atguigu.atcrowdfunding;

/**
 * 自定义异常
 */
public class LoginException extends RuntimeException{

    public LoginException(){}

    public LoginException(String message){
        super(message);
    }
}
