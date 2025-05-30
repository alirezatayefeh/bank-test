package com.test.demo.dto;

import lombok.Data;

@Data
public class TransferRequest {
    private String sourceCardNumber;
    private String destinationCardNumber;
    private Double amount;
}
