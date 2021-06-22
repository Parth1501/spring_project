package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTestWithMock {

	@Mock
	ProductDAO mockDao;
	@Test
	void addNewProduct_Must_Return_NonZeroId_When_Value_GETEQ_10K() {
		Product paramToMethod=new Product("Name",10000,1,"someUrl");
//		ProductDAOInMemory doubleRole=new ProductDAOInMemory();
//		objUnderTest.setDao(doubleRole);
		
		ProductServiceImpl service=new ProductServiceImpl();
		Product saved=new Product();
		saved.setId(1);
		Mockito.when(mockDao.save(paramToMethod)).thenReturn(saved);
		service.setDao(mockDao);
		
		//Act
		
		int result=service.addNewProduct(paramToMethod);
		
		//Assert
		
		assertTrue(result>0);
	}

}
