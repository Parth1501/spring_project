package com.rakuten.training.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rakuten.training.domain.Product;
import com.rakuten.training.web.ProductController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {ProductController.class})
class ProductControllerTest {

	@MockBean
	ProductService mockService;
	
	@Autowired(required = true)
	MockMvc mockMvc;
	
	@Test
	void testGetById() throws Exception {
		//AAA
		//Arrange
		int id = 50;
		Product dataReturnedByMock = new Product("test", 10000, 1,"someUrl");
		dataReturnedByMock.setId(id);
		Mockito.when(mockService.findById(id)).thenReturn(dataReturnedByMock);
		
		//Act and Assert
		mockMvc
			.perform(MockMvcRequestBuilders.get("/products/{id}", id))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
		
	}

}

