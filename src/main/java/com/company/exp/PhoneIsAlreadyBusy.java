package com.company.exp;

public class PhoneIsAlreadyBusy extends RuntimeException {
    public PhoneIsAlreadyBusy(String message) {
        super(message);
    }
}
