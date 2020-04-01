package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.services.OrderService;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //get All orders for a user
    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

        return orderService.getAllOrders(userid);
    }

    //createOrder Method
    @PostMapping("/{userid}/orders")
    public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {

        return orderService.createOrders(userid, order);
    }

    //getOrderByOrderId
    @GetMapping("/{userid}/orders/{orderid}")
    public Optional<Order> getOrderByOrderId(@PathVariable("userid") Long userid, @PathVariable("orderid") Long orderid) throws UserNotFoundException, OrderNotFoundException {

        try {
            return orderService.getOrderByOrderId(userid, orderid);
        } catch (OrderNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
