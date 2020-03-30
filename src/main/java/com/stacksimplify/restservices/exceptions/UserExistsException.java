package com.stacksimplify.restservices.exceptions;

public class UserExistsException extends Exception {

    private static final long serialVersionUID = 9210599142132145511L;

    public UserExistsException(String message) {
        super(message);
    }

}
