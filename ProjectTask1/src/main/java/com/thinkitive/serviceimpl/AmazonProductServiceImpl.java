package com.thinkitive.serviceimpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.repository.AmazonProductRepository;
import com.thinkitive.services.AmazonProductService;
@Service
public class AmazonProductServiceImpl implements AmazonProductService {
	
	@Autowired
	AmazonProductRepository amazonProductRepository;
	
	@Override
	public AmazonProduct addAmazonProduct(AmazonProduct amazonProduct) {
		
		amazonProductRepository.save(amazonProduct);
	

		return amazonProduct;
	}

	@Override
	public List<AmazonProduct> getAllAmzonProducts() {
		
		return amazonProductRepository.findAll();
	}

	@Override
	public Optional<AmazonProduct> getAmazonProduct(Long id) {
		
		return amazonProductRepository.findById(id);
	}

	@Override
	public void updateAmazonProduct(AmazonProduct amazonProduct) {
			System.out.println("Update method called");
		 amazonProductRepository.save(amazonProduct);
	}

	@Override
	public void deleteAmazonProductById(Long amazonProductId) {
		
		amazonProductRepository.deleteById(amazonProductId);
	}

}
