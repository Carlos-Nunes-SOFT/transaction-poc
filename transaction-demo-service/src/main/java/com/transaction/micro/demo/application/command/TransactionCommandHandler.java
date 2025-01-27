package com.transaction.micro.demo.application.command;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.mapper.TransactionMapper;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.builder.TransactionBuilder;
import com.transaction.micro.demo.infrastructure.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandHandler {

    private static final Logger logger = LoggerFactory.getLogger(TransactionCommandHandler.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionBuilder transactionBuilder;

    @Transactional
    public TransactionDto createTransaction(Long userId, CreateTransactionCommand request){
        logger.info("Received request to create transaction: userId={}, amount={}, type={}" +
                userId, request.amount, request.type);

        Transaction transaction = this.transactionBuilder
                .newTransaction(userId, request.amount, request.type)
                .build();

        logger.info("Saving transaction: {}", transaction);

        Transaction savedTransaction = this.transactionRepository.save(transaction);

        logger.info("Transaction saved successfully: {}", savedTransaction);

        return this.transactionMapper.toDto(transaction);
    }
}