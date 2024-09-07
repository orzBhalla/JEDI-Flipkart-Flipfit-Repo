package com.flipkart.exception;

public class InvalidPanCardException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid Pan Card. Please enter correct details";
    }
}
