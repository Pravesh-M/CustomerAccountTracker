package com.practice.customer.controller;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.model.Account;
import com.practice.customer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountControlller {

    @Autowired
    private AccountService service;

    @PostMapping("/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        service.addAccount(account);
        return new ResponseEntity<>("Account Created Successfully" , HttpStatus.CREATED);
    }

    @GetMapping("/{accId}")
    public ResponseEntity<Account> getAccount(@PathVariable int accId) throws EntityNotExistException {
        return new ResponseEntity<>(service.getAccount(accId), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAccounts() {
        return new ResponseEntity<>(service.getAccounts(), HttpStatus.FOUND);
    }

    @PutMapping("/{accId}")
    public ResponseEntity<String> updateAccount(@PathVariable int accId,@RequestBody Account account) throws EntityNotExistException {
        service.updateAccount(accId,account);
        return new ResponseEntity<>("Account Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{accId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accId) {
        service.deleteAccount(accId);
        return new ResponseEntity<>("Account Deleted Successfully",HttpStatus.OK);
    }
}
