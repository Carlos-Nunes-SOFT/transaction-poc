package com.transaction.micro.demo.application.controller;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import com.transaction.micro.demo.application.proxy.UserServiceProxy;
import com.transaction.micro.demo.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private UserServiceProxy proxy;

    public TransactionController(UserServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/")
    public List<TransactionDto> getTransactionForUserId(@PathVariable Long userId){
        //SEND ID TO QUERY TO HANDLE AND GET TRANSACTION DTO
    }
}
