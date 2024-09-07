package com.flipkart.exception;

public class InvalidPhoneNumberException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid phone number. Please enter correct phone number";
    }
}
