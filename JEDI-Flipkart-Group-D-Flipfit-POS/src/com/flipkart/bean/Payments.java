package com.flipkart.bean;

public class Payments {


        // Card details
        private String cardNumber;
        private String expiryDate;
        private String name;
        private String cvv;

        // Simulated OTP value
        private static final String OTP = "123456";
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

//        // Scanner for input
//        private Scanner scanner;
//
//        public Payments() {
//            scanner = new Scanner(System.in);
//        }

//       public void processPayments()  {
//            collectCardDetails();
//            if (validateCardDetails()) {
//                System.out.println("Card details validated successfully.");
//                requestOTP();
//            } else {
//                System.out.println("Invalid card details. Payment failed.");
//            }
//        }
//
//        private void requestOTP() {
//            System.out.print("Enter the OTP sent to your registered mobile number: ");
//            String enteredOTP = scanner.nextLine();
//
//            if (OTP.equals(enteredOTP)) {
//                System.out.println("OTP verified successfully. Payment successful!");
//            } else {
//                System.out.println("Invalid OTP. Payment failed.");
//            }
//        }
//
//        private boolean validateCardDetails() {
//            // Simple validation checks
//            if (cardNumber <= 0 || expiryDate.isEmpty() || name.isEmpty() || cvv.length() != 3) {
//                return false;
//            }
//            // Additional validation logic can be added here (e.g., check if the card number format is correct)
//            return true;
//        }
//
//        private void collectCardDetails() {
//            System.out.print("Enter card number: ");
//            cardNumber = Integer.parseInt(scanner.nextLine());
//
//            System.out.print("Enter expiry date (MM/YY): ");
//            expiryDate = scanner.nextLine();
//
//            System.out.print("Enter cardholder's name: ");
//            name = scanner.nextLine();
//
//            System.out.print("Enter CVV: ");
//            cvv = scanner.nextLine();
//        }

//        public static void main(String[] args) {
//            Payments payment = new Payments();
//            payment.processPayments();
//        }
    }


