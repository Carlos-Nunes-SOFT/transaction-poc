package com.transaction.micro.demo.application.queries;

public class GetTransactionsByUserIdQuery {
    public Long userId;

    public GetTransactionsByUserIdQuery(Long userId) {
        this.userId = userId;
    }
}
