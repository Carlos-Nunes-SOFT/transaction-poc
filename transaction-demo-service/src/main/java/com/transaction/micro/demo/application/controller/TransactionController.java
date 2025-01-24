package com.transaction.micro.demo.application.controller;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.proxy.UserServiceProxy;
import com.transaction.micro.demo.application.queries.GetTransactionsByUserIdQuery;
import com.transaction.micro.demo.application.queries.TransactionQueryHandler;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private UserServiceProxy proxy;
    private TransactionQueryHandler transactionQueryHandler;

    public TransactionController(UserServiceProxy proxy, TransactionQueryHandler transactionQueryHandler) {
        this.proxy = proxy;
        this.transactionQueryHandler = transactionQueryHandler;
    }

    @GetMapping("/transaction/transactions")
    public List<TransactionDto> getTransactionForUserId(@RequestParam(name = "userId") Long userId){
        return transactionQueryHandler.getTransactionsByUserId(new GetTransactionsByUserIdQuery(userId));
    }
}
