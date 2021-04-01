package com.thinkitive.services;

import java.util.List;
import java.util.Optional;

import com.thinkitive.entity.AmazonProduct;

public interface AmazonProductService {
	public AmazonProduct addAmazonProduct(AmazonProduct amazonProduct);
	public List<AmazonProduct> getAllAmzonProducts();
	public Optional<AmazonProduct> getAmazonProduct(Long id);
	public void updateAmazonProduct(AmazonProduct amazonProduct);
	public void deleteAmazonProductById(Long amazonProductId);

}
