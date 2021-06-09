//package com.rakuten.training;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.rakuten.training.dal.ProductDAO;
//import com.rakuten.training.dal.ProductDAOInMemory;
//import com.rakuten.training.service.ProductService;
//import com.rakuten.training.service.ProductServiceImpl;
//import com.rakuten.training.ui.ProductUI;
//
//@Configuration
//public class ProductAppConfiguration {
//	
//	@Bean
//	public ProductDAO daoObj() {
//		ProductDAOInMemory dao=new ProductDAOInMemory();
//		return dao;
//	}
//	
//	@Bean
//	public ProductService serviceObj() {
//		ProductServiceImpl service=new ProductServiceImpl();
//		service.setDao(daoObj());
//		return service;
//	}
//	
//	@Bean
//	public ProductUI uiObj() {
//		ProductUI ui=new ProductUI();
//		ui.setService(serviceObj());
//		return ui;
//		
//	}
//}
