package com.stacksimplify.restservices.exceptions;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 5096592057975296577L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
