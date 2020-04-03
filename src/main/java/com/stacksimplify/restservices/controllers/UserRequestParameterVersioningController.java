package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/versioning/params/users")
public class UserRequestParameterVersioningController {

    //Autowire the UserService

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    //getUserById Method
    //Request Parameter based Versioning - V1
    @GetMapping(value = "/{id}", params = "version=1")
    public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);

        if (!userOptional.isPresent())
            throw new UserNotFoundException("User is not found");

        User user = userOptional.get();
        //map() - from user converts to UserDtoV1
        UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);

        return userDtoV1;

    }

    //getUserById Method
    //Request Parameter based Versioning - V2
    @GetMapping(value = "/{id}", params = "version=2")
    public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);

        if (!userOptional.isPresent())
            throw new UserNotFoundException("User is not found");

        User user = userOptional.get();
        //map() - from user converts to UserDtoV2
        UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);

        return userDtoV2;

    }
}
