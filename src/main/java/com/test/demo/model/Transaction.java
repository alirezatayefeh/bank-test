package com.test.demo.model;

import com.test.demo.model.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_card_id", nullable = false)
    private Card sourceCard;

    @ManyToOne
    @JoinColumn(name = "destination_card_id", nullable = false)
    private Card destinationCard;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
