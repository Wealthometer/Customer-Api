package com.wealth.customerservices.controllers;

import com.wealth.customerservices.dtos.CustomerDTO;
import com.wealth.customerservices.dtos.ResponseWrapper;
import com.wealth.customerservices.model.Customer;
import com.wealth.customerservices.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/v1.0")
    public List<Customer> fetchCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveCustomer( @RequestBody CustomerDTO customerDTO){

        Customer customer = Customer.builder()
                .accountNo(customerDTO.getAccountNo())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .phoneNumber(customerDTO.getPhoneNumber())
                .build();

        Customer savedCustomer= customerService.addCustomer(customer);

        if(savedCustomer != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Customer>(savedCustomer));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer could not be saved"));

    }



}
