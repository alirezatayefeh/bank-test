package com.test.demo.model.enums;

public enum TransactionStatus {
    PENDING("در انتظار", 1),
    COMPLETED("تکمیل شده", 2),
    FAILED("ناموفق", 3);

    TransactionStatus(String description, int code) {}
}
