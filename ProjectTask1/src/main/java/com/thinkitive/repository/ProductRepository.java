package com.thinkitive.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductName(String string);

}
