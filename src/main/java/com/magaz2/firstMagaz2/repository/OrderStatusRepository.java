package com.magaz2.firstMagaz2.repository;

import com.magaz2.firstMagaz2.Entity.OrderStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("orderStatusRepository")
@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
}
