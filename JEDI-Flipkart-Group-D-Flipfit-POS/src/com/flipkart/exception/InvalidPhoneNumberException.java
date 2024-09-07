package com.flipkart.exception;

public class InvalidPhoneNumberException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid Phone Number. Please enter correct phone number";
    }
}
