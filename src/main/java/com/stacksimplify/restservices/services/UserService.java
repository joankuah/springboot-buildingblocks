package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//Service
@Service
public class UserService {

    //Autowire the UserRepository
    @Autowired
    private UserRepository userRepository;

    //getAllUsers Method
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    //createUser Method
    public User createUser(User user) throws UserExistsException {
        //if user exists using username
        User existingUser = userRepository.findByUsername(user.getUsername());

        //if not exists throw UserExistsException
        if (existingUser != null) {
            throw new UserExistsException("User already exists in repository");
        }

        return userRepository.save(user);

    }

    //getUserById Method
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFoundException("User not found in user Repository");
        }

        return user;
    }

    //updateUserById
    public User updateUserById(Long id, User user) throws UserNotFoundException {

        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("Unable to update user, please provide the correct user id");
        }
        user.setUserId(id);
        return userRepository.save(user);
    }

    //deleteUserById
    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to delete user, please provide the correct user id");
        }
        userRepository.deleteById(id);
    }

    //getUserByUsername
    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
