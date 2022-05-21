package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.Delivery;
import com.magaz2.firstMagaz2.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public void addDelivery(Delivery delivery){
        deliveryRepository.save(delivery);
    }
}
