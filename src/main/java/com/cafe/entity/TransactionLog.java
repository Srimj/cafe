package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class TransactionLog {

    public TransactionLog(String transactionId, String operation, String status, String error){
        this.transactionId = transactionId;
        this.operation = operation;
        this.status = status;
        this.error = error;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private String operation;
    private String status;
    private String error;
    private LocalDateTime createDt = LocalDateTime.now();
}
