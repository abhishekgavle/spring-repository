package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.productentity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
