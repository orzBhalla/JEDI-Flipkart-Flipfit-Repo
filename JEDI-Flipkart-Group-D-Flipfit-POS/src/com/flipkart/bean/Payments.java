package com.flipkart.bean;

public class Payments {

    private int paymentsId;
    private String cardNumber;
    private String expiryDate;
    private String name;
    private String cvv;

    public int getPaymentId() {
        return paymentsId;
    }

    public void setPaymentsId(int paymentsId) {
        this.paymentsId = paymentsId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}


