package com.transaction.micro.demo.domain;

import com.transaction.micro.demo.domain.enums.TransactionType;
import org.bson.types.ObjectId;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transaction")
public class Transaction {

    @Id
    private ObjectId id;

    private Integer amount;

    private TransactionType type;

    private Long userId;

    private LocalDateTime timestamp;

    public Transaction(){}

    public Transaction(Long userId, Integer amount, TransactionType type) {
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public ObjectId getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
