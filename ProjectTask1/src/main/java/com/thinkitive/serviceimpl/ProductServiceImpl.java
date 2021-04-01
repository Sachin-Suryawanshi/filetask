package com.thinkitive.serviceimpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.entity.Product;

import com.thinkitive.repository.ProductRepository;
import com.thinkitive.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		productRepository.save(product);

		return product;
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
		
	}

	
}

//try {
//	BufferedReader br = new BufferedReader(new FileReader("src/main/resources/demo.xlsx"));
//	try {
//		while ((line = br.readLine()) != null) {
//			String[] data = line.split(",");
//			Product pt = new Product();
//			AmazonProduct amazonPt = new AmazonProduct();
//			pt.setProductName(data[0]);
//			amazonPt.setArticleNumber(data[1]);
//			pt.setAmazonProduct(amazonPt);
//			if (productRepository.findByProductName(data[0]) == null
//					&& amazonProductRepository.findByArticleNumber(data[1]) == null) {
//				
//				productRepository.save(pt);
//			}
//			else
//			{
//				throw new RuntimeException("Product already Exits");
//			}
//
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//} catch (FileNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
