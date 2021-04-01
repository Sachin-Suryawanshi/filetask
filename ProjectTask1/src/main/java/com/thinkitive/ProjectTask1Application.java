package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.entity.Product;
import com.thinkitive.repository.AmazonProductRepository;
import com.thinkitive.repository.ProductRepository;

@SpringBootApplication
public class ProjectTask1Application {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	AmazonProductRepository amzRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProjectTask1Application.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedOrigins("*");
	}
	};
	} 

//	@Override
//	public void run(String... args) throws Exception {
//	Product p=new Product();
//	p.setProductName("Abc");
//	AmazonProduct ap=new AmazonProduct();
//	ap.setArticleNumber("12233");
//	p.setAmazonProduct(ap);
//	ap.setProduct(p);
//	amzRepo.save(ap);
//	
//		
//	}

}
