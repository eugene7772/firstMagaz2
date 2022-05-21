package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.OrderStatus;
import com.magaz2.firstMagaz2.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStatusService {
    @Autowired
    OrderStatusRepository orderStatusRepository;

    public Optional<OrderStatus> getOrderStatusById(Long id){
        return orderStatusRepository.findById(id);
    }
}
