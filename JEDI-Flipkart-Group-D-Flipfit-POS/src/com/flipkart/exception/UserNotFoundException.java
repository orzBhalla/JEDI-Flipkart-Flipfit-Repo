package com.flipkart.exception;

public class UserNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "User not found. Please register or login using different account";
    }
}
