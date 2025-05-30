package com.test.demo.service;

import com.test.demo.dto.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    private KafkaTemplate<String, TransferRequest> kafkaTemplate;

    public String initiateTransfer(TransferRequest request) {
        //FIXME: Should initialize kafka consumer

        return "Transfer initiated. Destination: ";
    }
}
