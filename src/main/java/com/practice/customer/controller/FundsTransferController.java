package com.practice.customer.controller;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.exception.InsufficientBalanceException;
import com.practice.customer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account/transfer")
public class FundsTransferController {

    @Autowired
    private FundTransferService service;

    @PutMapping("/{senderId}/{receiverId}/{funds}")
    public ResponseEntity<String> transferFunds(@PathVariable int senderId , @PathVariable int receiverId, @PathVariable double funds) throws InsufficientBalanceException, EntityNotExistException {
        service.transferFunds(senderId,receiverId,funds);
        return new ResponseEntity<>("Funds Transferred Successfully", HttpStatus.OK);
    }
}
