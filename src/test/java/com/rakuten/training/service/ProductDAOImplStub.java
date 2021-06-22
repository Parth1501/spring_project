package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

public class ProductDAOImplStub implements ProductDAO {

	@Override
	public Product save(Product toBeSaved) {
		Product saved = new Product();
		saved.setId(1);
		return saved;
	}

	@Override
	public List<Product> findAll() {

		return null;
	}

	@Override
	public Product findById(int id) {

		return null;
	}

	@Override
	public void deleteById(int id) {

	}

}
