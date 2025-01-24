package com.transaction.micro.demo.application.command;

import com.transaction.micro.demo.domain.enums.TransactionType;

public class CreateTransactionCommand {
    public Long userId;
    public Integer amount;
    public TransactionType type;
}
