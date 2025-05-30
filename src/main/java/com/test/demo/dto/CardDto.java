package com.test.demo.dto;

import lombok.Data;

@Data
public class CardDto {
    private String cardNumber;
    private Double balance;
    private Double transferLimit;
    private String bankName;
    private String userFullName;
}
