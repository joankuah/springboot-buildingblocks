package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    //getAllOrders Method

    public List<Order> getAllOrders(Long userid) throws  UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userid);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        return userOptional.get().getOrders();
    }

    //createOrders Method
    public Order createOrders(Long userid, Order order) throws  UserNotFoundException{
        Optional<User> userOptional = userRepository.findById(userid);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        User user = userOptional.get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    //getOrderByOrderId
    public Optional<Order> getOrderByOrderId(Long userid, Long orderid) throws UserNotFoundException, OrderNotFoundException {
        Optional<User> user = userRepository.findById(userid);

        if(!user.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        Optional<Order> order = orderRepository.findById(orderid);
        if(!order.isPresent())
            throw new OrderNotFoundException("Order not found");

        if(user.get().getUserid() != order.get().getUser().getUserid())
            throw new OrderNotFoundException("Order not found");

        return order;

    }

}
