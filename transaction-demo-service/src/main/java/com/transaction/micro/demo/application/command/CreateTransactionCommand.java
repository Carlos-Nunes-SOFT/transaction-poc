package com.transaction.micro.demo.application.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transaction.micro.demo.domain.enums.TransactionType;

public class CreateTransactionCommand {

    public Integer amount;

    public TransactionType type;

    public CreateTransactionCommand(Integer amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }
}
