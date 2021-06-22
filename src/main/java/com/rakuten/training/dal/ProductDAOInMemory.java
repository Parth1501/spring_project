package com.rakuten.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import com.rakuten.training.domain.Product;

@Primary
@Repository
@Transactional
public class ProductDAOInMemory implements ProductDAO{
	Map<Integer, Product> data=new HashMap<Integer, Product>();
	int idSeq=0;
	public Product save(Product toBeSaved) {
		int id=++idSeq;
		toBeSaved.setId(id);
		data.put(id, toBeSaved);
		return toBeSaved;
	}
	public List<Product> findAll() {
		return new ArrayList<Product>(data.values());
	}

	public Product findById(int id) {
		return data.get(id);
	}

	public void deleteById(int id) {
		data.remove(id);
	
	}

}
