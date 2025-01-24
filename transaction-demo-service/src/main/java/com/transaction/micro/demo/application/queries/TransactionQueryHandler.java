package com.transaction.micro.demo.application.queries;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.mapper.TransactionMapper;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionQueryHandler {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public TransactionQueryHandler(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public List<TransactionDto> getTransactionsByUserId(GetTransactionsByUserIdQuery request) {

        List<Transaction> transactions = this.transactionRepository.findByUserId(request.userId);

        return transactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }
}
