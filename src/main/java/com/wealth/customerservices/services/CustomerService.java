package com.wealth.customerservices.services;

import com.wealth.customerservices.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

}
