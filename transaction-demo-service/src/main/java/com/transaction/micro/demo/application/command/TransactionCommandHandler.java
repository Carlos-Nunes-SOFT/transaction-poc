package com.transaction.micro.demo.application.command;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.mapper.TransactionMapper;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.builder.TransactionBuilder;
import com.transaction.micro.demo.infrastructure.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandHandler {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionBuilder transactionBuilder;

    @Transactional
    public TransactionDto createTransaction(Long userId, CreateTransactionCommand request){
        Transaction transaction = this.transactionBuilder
                .newTransaction(userId, request.amount, request.type)
                .build();

        this.transactionRepository.save(transaction);

        return this.transactionMapper.toDto(transaction);
    }
}