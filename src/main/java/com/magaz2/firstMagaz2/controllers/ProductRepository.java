package com.magaz2.firstMagaz2.controllers;

import com.magaz2.firstMagaz2.controllers.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Qualifier("productRepository")
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findByProductType(ProductType productType);
}
