package com.stacksimplify.restservices.exceptions;

public class UserNameNotFoundException extends Exception {

    private static final long serialVersionUID = 6842467830199182182L;

    //Superclass Constructor
    public UserNameNotFoundException(String message) {
        super(message);
    }

}
