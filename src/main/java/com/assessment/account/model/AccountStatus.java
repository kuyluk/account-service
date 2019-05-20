package com.assessment.account.model;

public enum AccountStatus {

    CREATED("account has been successfully added");

    private String message;

    AccountStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
