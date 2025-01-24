package com.transaction.micro.demo.application.controller;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.queries.GetTransactionsByUserIdQuery;
import com.transaction.micro.demo.application.queries.TransactionQueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private TransactionQueryHandler transactionQueryHandler;

    public TransactionController(TransactionQueryHandler transactionQueryHandler) {
        this.transactionQueryHandler = transactionQueryHandler;
    }

    @GetMapping("/transaction/transactions")
    public List<TransactionDto> getTransactionsByUserId(@RequestParam(name = "userId") Long userId){
        return transactionQueryHandler.getTransactionsByUserId(new GetTransactionsByUserIdQuery(userId));
    }
}
