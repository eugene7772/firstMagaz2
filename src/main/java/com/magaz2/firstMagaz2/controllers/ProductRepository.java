package com.magaz2.firstMagaz2.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Qualifier("productRepository")
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
     List<Product> findByProductType(ProductType productType);
     List<Product> findAll();
}
