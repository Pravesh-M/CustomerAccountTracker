package com.practice.customer.controller;

import com.practice.customer.model.Customer;
import com.practice.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Customizer;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerRepo repo;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return repo.findById(customerId).get();
    }
}
