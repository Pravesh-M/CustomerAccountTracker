package com.practice.customer.service;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.model.Account;
import com.practice.customer.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    public void addAccount(Account account) {
        repo.save(account);
    }

    public Account getAccount(int accId) throws EntityNotExistException {
        return repo.findById(accId)
                .orElseThrow(() -> new EntityNotExistException("Account with id : " +accId + " is not present"));
    }

    public List<Account> getAccounts() {
        return repo.findAll();
    }
    public void updateAccount(int accId, Account account) throws EntityNotExistException {
        Account dbAcc = getAccount(accId);
        dbAcc.setAccountType(account.getAccountType());
        dbAcc.setBalance(account.getBalance());
        repo.save(dbAcc);

    }

    public void deleteAccount(int accId) {
        repo.deleteById(accId);
    }
}
