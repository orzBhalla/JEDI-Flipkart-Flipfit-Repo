package com.flipkart.exception;

public class InvalidAadhaarCardException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid Aadhaar Card. Please enter correct Aadhaar Card";
    }
}
