package com.transaction.micro.demo.domain;

import com.transaction.micro.demo.domain.enums.TransactionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction {

    @Id
    private String id;

    private Integer amount;

    private TransactionType type;

    private Long userId;

    public Transaction(){}

    public Transaction(Long userId, Integer amount, TransactionType type) {
        this.userId = userId;
        this.amount = amount;
        this.type = type;
    }

    public void setId(String id) {
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

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
