package com.transaction.micro.demo.application.mapper;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.domain.Transaction;
import com.transaction.micro.demo.domain.enums.TransactionType;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    //Mapper build; Ver estruturas alternativas para o mapper

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "id", qualifiedByName = "mapObjectIdToString")
    @Mapping(target = "type", qualifiedByName = "mapEnumToString")
    @Mapping(target = "timestamp", source = "timestamp")
    TransactionDto toDto(Transaction transaction);

    @Named("mapObjectIdToString")
    static String mapObjectIdToString(ObjectId id){
        return (id != null) ? id.toHexString() : null;
    }

    @Named("mapEnumToString")
    static String mapEnumToString(TransactionType type){
        return (type != null) ? type.name() : null;
    }
}
