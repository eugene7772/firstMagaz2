package com.magaz2.firstMagaz2.service;


import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
        public List<Product> getAllProducts(){
            return productRepository.findAll();
        }
    public void addProduct(Product product){
            productRepository.save(product);
    }
    public void removeProductById(Long id){
            productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(Long id){
            return  productRepository.findById(id);
    }
    public List<Product> getAllProductsByProductTypeId(Long id){
            return productRepository.findAllByProductTypeId(id);
    }
}
