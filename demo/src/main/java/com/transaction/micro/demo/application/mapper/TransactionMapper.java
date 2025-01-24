package com.transaction.micro.demo.application.mapper;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.domain.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "timestamp", expression = "java(java.time.LocalDateTime.now().toString())")
    TransactionDto toDto(Transaction transaction);
}
