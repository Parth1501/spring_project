package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;

import com.rakuten.training.domain.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	ProductDAO dao;   //=new ProductDAOInMemory();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public int addNewProduct(Product toBeAdded) {
		if(toBeAdded.getPrice()*toBeAdded.getQoh()<10000) {
			throw new IllegalArgumentException("The $ is less than 10000");
		}
		toBeAdded=dao.save(toBeAdded);
		return toBeAdded.getId();
	}

	public void removeExisting(int id) {
		Product exisiting=dao.findById(id);
		if(exisiting.getPrice()*exisiting.getQoh()<100000) {
			dao.deleteById(id);
		}
		
		
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
