package com.library.security.user.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        super("User with username already exist, try again.");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
