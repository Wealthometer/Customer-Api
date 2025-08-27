package com.wealth.customerservices.services;


import com.wealth.customerservices.model.Customer;
import com.wealth.customerservices.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        if(customer!=null){
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
