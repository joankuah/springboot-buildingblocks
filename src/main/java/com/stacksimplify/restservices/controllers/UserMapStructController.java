package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    //getAllUserDtos Method
    @GetMapping
    public List<UserMsDto> getAllUserDtos() {
        return userMapper.userToUserMsDtos(userRepository.findAll());
    }

    //getUserById Method
    @GetMapping("/{id}")
    public UserMsDto getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return userMapper.userToUserMsDto(user);
    }
}
