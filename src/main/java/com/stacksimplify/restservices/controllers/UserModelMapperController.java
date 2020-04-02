package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

//Controller
@RestController
@RequestMapping(value = "modelmapper/users")
public class UserModelMapperController {

    //Autowire the UserService

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    //getUserById Method
    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);

        if (!userOptional.isPresent())
            throw new UserNotFoundException("User is not found");

        User user = userOptional.get();
        UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);

        return userMmDto;

    }
}
