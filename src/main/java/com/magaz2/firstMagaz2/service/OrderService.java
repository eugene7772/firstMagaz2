package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.Order;
import com.magaz2.firstMagaz2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);

    }
    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
