package com.library.security.user.exceptions;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("User with username already exist, try again.");
    }

    public UserFoundException(String message){
        super(message);
    }
}
