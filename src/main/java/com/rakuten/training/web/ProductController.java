package com.rakuten.training.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> getAllProduct() {
		return service.findAll();
	}

}
