package com.magaz2.firstMagaz2.repository;

import com.magaz2.firstMagaz2.Entity.Delivery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("deliveryRepository")
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
