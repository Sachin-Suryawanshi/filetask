package com.thinkitive.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.serviceimpl.AmazonProductServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AmazonProductController {
	@Autowired
	AmazonProductServiceImpl amazonProductService;

	@GetMapping(value = "/getallamazonproducts")
	public List<AmazonProduct> showAllAmazonProducts() {
		return amazonProductService.getAllAmzonProducts();
	}

	@GetMapping(value = "/getamazonproduct/{id}")
	public Optional<AmazonProduct> getAmazonProduct(@PathVariable("id") Long id) {
		return amazonProductService.getAmazonProduct(id);
	}

	@PutMapping(value = "/updateamazonproduct")
	public String updateAmazonProduct(@RequestBody AmazonProduct amazonProduct) {
		amazonProductService.updateAmazonProduct(amazonProduct);
		return "Updated Successfully";
	}

	@DeleteMapping(value = "/deleteamazonproduct/{amazonProductId}")
	public String deleteAmazonProductById(@PathVariable("amazonProductId") Long amazonProductId) {
		amazonProductService.deleteAmazonProductById(amazonProductId);
		return "Amazon Product Deleted Successfully";
	}

}
