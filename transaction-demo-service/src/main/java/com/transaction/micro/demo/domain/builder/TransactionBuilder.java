package com.transaction.micro.demo.domain.builder;

import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.enums.TransactionType;

import java.time.LocalDateTime;

public interface TransactionBuilder {
    Transaction build();
    TransactionBuilder newTransaction(Long userId, Integer amount, TransactionType type);
}

