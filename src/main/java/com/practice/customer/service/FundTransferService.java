package com.practice.customer.service;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.exception.InsufficientBalanceException;
import com.practice.customer.model.Account;
import com.practice.customer.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundTransferService {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepo repo;

    public void transferFunds(int senderAccId, int receiverAccId, double funds) throws InsufficientBalanceException, EntityNotExistException {
        Account sender = service.getAccount(senderAccId);
        Account receiver = service.getAccount(receiverAccId);
        if((sender.getBalance()<funds))
            throw new InsufficientBalanceException("Sender does not have Sufficient Balance");

        receiver.setBalance(receiver.getBalance()+funds);
        sender.setBalance(sender.getBalance()-funds);
        repo.save(sender);
        repo.save(receiver);
    }

}
