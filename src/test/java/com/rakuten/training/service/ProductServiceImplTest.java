package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

class ProductServiceImplTest {
	ProductServiceImpl objUnderTest=new ProductServiceImpl();
	ProductDAO mockDao=Mockito.mock(ProductDAO.class);

	@Test
	void addNewProduct_Must_Return_NonZeroId_When_Value_GETEQ_10K() {
		
		//Arrange
		
		
		Product paramToMethod=new Product("Name",10000,1,"someUrl");
//		ProductDAOInMemory doubleRole=new ProductDAOInMemory();
//		objUnderTest.setDao(doubleRole);
		
		
		Product saved=new Product();
		saved.setId(1);
		Mockito.when(mockDao.save(paramToMethod)).thenReturn(saved);
		objUnderTest.setDao(mockDao);
		
		//Act
		
		int result=objUnderTest.addNewProduct(paramToMethod);
		
		//Assert
		
		assertTrue(result>0);
		
	}
	
	@Test
	void addNewProduct_Must_Throws_IllegalStateException_When_ProductPrice_Mul_ProductQoh() {
		
		//Act and assert
		assertThrows(IllegalStateException.class, ()->{
			Product paramToMethod=new Product("Name",1000,1,"someUrl");
			objUnderTest.addNewProduct(paramToMethod);
		});
		
		
	}
	
	@Test
	void removeExisting_Must_Delete_Product_When_Value_LT_100k() {
		//AAA
		//Arrange
		ProductServiceImpl service = new ProductServiceImpl();
		int productId = 5;
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		Product dataReturnedByMock = new Product("test", 99999, 1,"someUrl");
		Mockito.when(mockDAO.findById(productId)).thenReturn(dataReturnedByMock);
		service.setDao(mockDAO);
		
		//Act
		service.removeExisting(productId);
		
		//Assert
		Mockito.verify(mockDAO).deleteById(productId);
	}
	
	@Test
	void removeExisting_Must_Throw_Exception_When_Value_GT_100k() {
		
		assertThrows(IllegalStateException.class,()-> {
			int  id=5;
			Product p=new Product("name",100001,2,"someUrl");
			Mockito.when(mockDao.findById(id)).thenReturn(p);
			objUnderTest.setDao(mockDao);
			objUnderTest.removeExisting(id);
			
			
		});
	}
	
	@Test
	void findAll_Must_Return_ListofProduct() {
		objUnderTest.setDao(mockDao);
		assertTrue(objUnderTest.findAll()!=null);
	}

}
