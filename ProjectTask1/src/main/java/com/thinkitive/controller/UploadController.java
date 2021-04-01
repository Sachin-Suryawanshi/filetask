package com.thinkitive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.entity.Product;
import com.thinkitive.serviceimpl.UploadService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UploadController {
	@Autowired
	UploadService uploadService;

	@PostMapping(value = "/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws Throwable {
		List<AmazonProduct> productList = uploadService.upload(file);
		uploadService.checkEntry(productList);

		return "Added Successfully";

	}
	@GetMapping(value = "/hello")
	public String hello()
	{
		return "Hello from spring";
	}

}
