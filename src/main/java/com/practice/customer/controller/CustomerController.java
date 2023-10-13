package com.practice.customer.controller;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.model.Customer;
import com.practice.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable int customerId , @RequestBody Customer customer) throws EntityNotExistException {

        service.updateCustomer(customerId,customer);
        return new ResponseEntity<>("Customer Updated Successfully" , HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) throws EntityNotExistException {
        return new ResponseEntity<>(service.getCustomer(customerId),HttpStatus.FOUND);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<> (service.getCustomers(),HttpStatus.FOUND);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
    }
}
