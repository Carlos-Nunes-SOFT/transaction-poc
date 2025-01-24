package com.transaction.micro.demo.domain.builder;

import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.enums.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionBuilderImpl implements TransactionBuilder{
    private Transaction transaction;

    @Override
    public Transaction build() {
        if(transaction==null)
            throw new IllegalArgumentException("The transaction object is not initialized.");
        return transaction;
    }

    @Override
    public TransactionBuilder newTransaction(Long userId, Integer amount, TransactionType type) {
        transaction = new Transaction(userId, amount, type);
        return this;
    }
}