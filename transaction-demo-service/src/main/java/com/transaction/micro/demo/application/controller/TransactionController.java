package com.transaction.micro.demo.application.controller;

import com.transaction.micro.demo.application.command.CreateTransactionCommand;
import com.transaction.micro.demo.application.command.TransactionCommandHandler;
import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.queries.GetTransactionsByUserIdQuery;
import com.transaction.micro.demo.application.queries.TransactionQueryHandler;
import com.transaction.micro.demo.application.utils.EncodingUtils;
import org.springframework.web.bind.annotation.*;

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
    public List<TransactionDto> getTransactionsByUserId(@RequestParam(name = "userId") String encodedUserId){
        Long userId = EncodingUtils.decode(encodedUserId);
        return transactionQueryHandler.getTransactionsByUserId(new GetTransactionsByUserIdQuery(userId));
    }

    @PostMapping("/transaction/execute-transaction")
    public TransactionDto createTransaction(@RequestParam(name = "userId") String encodedUserId,
                                            @RequestBody CreateTransactionCommand request) {
        Long userId = EncodingUtils.decode(encodedUserId);
        return this.transactionCommandHandler.createTransaction(userId, request);
    }
}
