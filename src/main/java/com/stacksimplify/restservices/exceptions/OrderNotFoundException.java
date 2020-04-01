package com.stacksimplify.restservices.exceptions;

public class OrderNotFoundException extends Exception {

    private static final long serialVersionUID = 7197313266730983203L;

    public OrderNotFoundException(String message) {
        super(message);
    }
}

