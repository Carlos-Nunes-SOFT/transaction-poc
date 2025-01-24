package com.transaction.micro.demo.application.controller;

import com.transaction.micro.demo.application.command.CreateTransactionCommand;
import com.transaction.micro.demo.application.command.TransactionCommandHandler;
import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.queries.GetTransactionsByUserIdQuery;
import com.transaction.micro.demo.application.queries.TransactionQueryHandler;
import com.transaction.micro.demo.domain.enums.TransactionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TransactionController {

    private TransactionQueryHandler transactionQueryHandler;
    private TransactionCommandHandler transactionCommandHandler;

    public TransactionController(TransactionQueryHandler transactionQueryHandler, TransactionCommandHandler transactionCommandHandler) {
        this.transactionQueryHandler = transactionQueryHandler;
        this.transactionCommandHandler = transactionCommandHandler;
    }

    @GetMapping("/transaction/transactions")
    public List<TransactionDto> getTransactionsByUserId(@RequestParam(name = "userId") Long userId){
        return transactionQueryHandler.getTransactionsByUserId(new GetTransactionsByUserIdQuery(userId));
    }

    @PostMapping("/transaction/execute-transaction")
    public TransactionDto createTransaction(@RequestParam(name = "userId") Long userId, @RequestBody CreateTransactionCommand request)
    {
        return this.transactionCommandHandler.createTransaction(userId, request);
    }
}
