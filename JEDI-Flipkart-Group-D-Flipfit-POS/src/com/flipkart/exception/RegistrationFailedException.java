package com.flipkart.exception;

public class RegistrationFailedException extends Exception{
    @Override
    public String getMessage(){
        return "registration failed. Please try again";
    }
}
