package com.practice.customer.repository;

import com.practice.customer.controller.CustomerController;
import com.practice.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
