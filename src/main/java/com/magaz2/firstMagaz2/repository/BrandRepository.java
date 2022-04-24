package com.magaz2.firstMagaz2.repository;

import com.magaz2.firstMagaz2.Entity.Brand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("brandRepository")
@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
