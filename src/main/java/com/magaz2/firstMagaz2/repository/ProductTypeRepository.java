package com.magaz2.firstMagaz2.repository;

import com.magaz2.firstMagaz2.Entity.ProductType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("productTypeRepository")
@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
}
