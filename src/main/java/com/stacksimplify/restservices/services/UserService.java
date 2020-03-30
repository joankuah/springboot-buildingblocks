package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
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
    public User createUser(User user) {

        return userRepository.save(user);

    }

    //getUserById Method
    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    //updateUserById
    public User updateUserById(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    //deleteUserById
    public void deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    //getUserByUsername
    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
