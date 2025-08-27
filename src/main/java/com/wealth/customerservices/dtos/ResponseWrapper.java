package com.wealth.customerservices.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseWrapper<T> implements Serializable {
    private T customer;
    private String message;

    public ResponseWrapper(T customer) {
        this.customer = customer;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}
