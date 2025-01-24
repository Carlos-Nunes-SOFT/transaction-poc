package com.transaction.micro.demo.application.proxy;

import com.transaction.micro.demo.application.dtos.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-demo-service", url ="localhost:8000")
public interface UserServiceProxy {

    @GetMapping("/user/{id}/transactions")
    public List<TransactionDto> getTransactionsByUserId(@PathVariable Long id);
}
