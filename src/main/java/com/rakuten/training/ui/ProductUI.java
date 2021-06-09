package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@Component
public class ProductUI {
	ProductService service; // = new ProductServiceImpl();
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	public void createProductServiceUI() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter product name: ");
			String name = s.nextLine();
			System.out.print("Enter product price: ");
			double price = Double.parseDouble(s.nextLine());
			System.out.print("Enter quantity: ");
			int qoh = Integer.parseInt(s.nextLine());

			Product product = new Product(name, price, qoh);
			int id = service.addNewProduct(product);
			System.out.println("New product added with id: " + id);
		}

	}

	public void getProductById(int id) {
		Product product = service.findById(id);
		System.out.println(product);

	}
}
