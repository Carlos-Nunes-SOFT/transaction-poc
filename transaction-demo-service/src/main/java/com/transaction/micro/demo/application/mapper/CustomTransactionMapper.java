package com.transaction.micro.demo.application.mapper;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.builder.TransactionBuilder;
import com.transaction.micro.demo.domain.enums.TransactionType;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomTransactionMapper {

    private final TransactionBuilder transactionBuilder;

    public CustomTransactionMapper(TransactionBuilder transactionBuilder) {
        this.transactionBuilder = transactionBuilder;
    }

    public TransactionDto toDto(Transaction transaction) {
        if (transaction == null)
            return null;
        return new TransactionDto(
                transaction.getUserId(),
                mapObjectIdToString(transaction.getId()),
                transaction.getAmount(),
                mapEnumToString(transaction.getType()),
                transaction.getTimestamp()
        );
    }
    public List<TransactionDto> toDtoList(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Transaction toEntity(TransactionDto dto) {
        if (dto == null) {
            return null;
        }

        return transactionBuilder
                .newTransaction(dto.getUserId(), dto.getAmount(), mapStringToEnum(dto.getType()))
                .build();
    }

    private String mapObjectIdToString(ObjectId id) {
        return (id != null) ? id.toHexString() : null;
    }

    private ObjectId mapStringToObjectId(String id) {
        return (id != null && !id.isEmpty()) ? new ObjectId(id) : null;
    }

    private String mapEnumToString(TransactionType type) {
        return (type != null) ? type.name() : null;
    }

    private TransactionType mapStringToEnum(String type) {
        return (type != null && !type.isEmpty()) ? TransactionType.valueOf(type) : null;
    }

}
