package com.test.demo.service;

import com.test.demo.dto.TransferRequest;
import com.test.demo.model.Transaction;
import com.test.demo.model.enums.TransactionStatus;
import com.test.demo.repository.CardRepository;
import com.test.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumerService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "card-transfers", groupId = "card-transfer-group")
    public void processTransfer(TransferRequest request) {
        //FIXME: Should be initialize transaction process & put in kafka producer
    }

    private Long getTransactionIdByRequest(TransferRequest request) {
        List<Transaction> transactions = transactionRepository.findAll();

        for (Transaction transaction : transactions) {
            if (transaction.getSourceCard().getCardNumber().equals(request.getSourceCardNumber())) {
                if (transaction.getDestinationCard().getCardNumber().equals(request.getDestinationCardNumber())) {
                    if (transaction.getAmount().equals(request.getAmount())) {
                        if (transaction.getStatus().equals(TransactionStatus.PENDING)) {
                            return transaction.getId();
                        }
                    }
                }
            }
        }

        return null;
    }
}
