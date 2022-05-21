package com.magaz2.firstMagaz2.repository;

import com.magaz2.firstMagaz2.Entity.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("orderRepository")
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
