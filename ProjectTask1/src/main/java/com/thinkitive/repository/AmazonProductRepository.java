package com.thinkitive.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.entity.AmazonProduct;
@Repository
public interface AmazonProductRepository extends JpaRepository<AmazonProduct, Long> {

	AmazonProduct findByArticleNumber(String string);

}
