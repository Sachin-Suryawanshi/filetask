package com.thinkitive.services;

import com.thinkitive.entity.Product;

public interface ProductService {
	Product addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Long productId);

}
