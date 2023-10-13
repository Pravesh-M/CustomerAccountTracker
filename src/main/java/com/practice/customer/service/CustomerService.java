package com.practice.customer.service;

import com.practice.customer.exception.EntityNotExistException;
import com.practice.customer.model.Customer;
import com.practice.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public void addCustomer(Customer customer) {
        repo.save(customer);
    }

    public void updateCustomer(int customerId , Customer customer) throws EntityNotExistException {
        Customer dbCust = getCustomer(customerId);
        dbCust.setCustomerName(customer.getCustomerName());
        dbCust.setCustomerEmail(customer.getCustomerEmail());
        dbCust.setAccounts(customer.getAccounts());
        repo.save(dbCust);

    }

    public Customer getCustomer(int customerId) throws EntityNotExistException {

        return repo.findById(customerId)
                .orElseThrow(() -> new EntityNotExistException("Customer with ID : "+customerId+" is not Present"));
    }

    public List<Customer> getCustomers() {

        return repo.findAll();
    }

    public void deleteCustomer(int customerId) {

        repo.deleteById(customerId);
    }

}
