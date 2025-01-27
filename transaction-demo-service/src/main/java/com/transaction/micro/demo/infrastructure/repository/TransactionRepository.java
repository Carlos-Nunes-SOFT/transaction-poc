package com.transaction.micro.demo.infrastructure.repository;

import com.transaction.micro.demo.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserId(Long userId);
}
