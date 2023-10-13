package com.practice.customer.repository;

import com.practice.customer.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
