package com.flipkart.business;

public interface PaymentsService {
    boolean collectCardDetails();
    boolean validateCardDetails();
    void requestOTP();
    public void processPayments();

}
