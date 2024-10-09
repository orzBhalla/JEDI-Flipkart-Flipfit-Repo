package com.flipkart.bean;

public class FlipFitCustomer extends FlipFitUser {
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    private String customerPhone;
}
