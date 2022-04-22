package com.magaz2.firstMagaz2.service;


import com.magaz2.firstMagaz2.Entity.ProductType;
import com.magaz2.firstMagaz2.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    public Iterable<ProductType> getAllproductType(){
        return productTypeRepository.findAll();
    }
    public void addProductType(ProductType productType){
        productTypeRepository.save(productType);
    }
    public void removeProductTypeById(Long id){
        productTypeRepository.deleteById(id);
    }
    public Optional<ProductType> getProductTypeById(Long id){
        return productTypeRepository.findById(id);
    }
}
