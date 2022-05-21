package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.Brand;
import com.magaz2.firstMagaz2.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public Iterable<Brand> getAllBrands(){
        return brandRepository.findAll();
    }
    public Optional<Brand> getBrandById(Long id){
        return brandRepository.findById(id);
    }
    public void addBrand(Brand brand){
        brandRepository.save(brand);
    }
    public void removeBrandId(Long id){
        brandRepository.deleteById(id);
    }
}
