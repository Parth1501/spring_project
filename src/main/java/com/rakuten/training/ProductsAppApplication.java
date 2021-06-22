package com.rakuten.training;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOJPAImpl;
import com.rakuten.training.dal.ProductRepository;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ProductServiceImpl;
import com.rakuten.training.service.ReviewService;
import com.rakuten.training.service.ReviewServiceImpl;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(ProductsAppApplication.class, args);
//		ProductUI product=springContainer.getBean(ProductUI.class);
//		ReviewServiceImpl service=springContainer.getBean(ReviewServiceImpl.class);
		
//		ReviewDAO r=springContainer.getBean(ReviewDAOJPAImpl.class);
//		Review r1=readData();
//		service.addReviewToProduct(r1, 8);
//		product.createProductServiceUI();
		
//		testProductQuries(springContainer);
		
//		testReviewQuries(springContainer);
//		testRepository(springContainer);
	}
	
	private static void testRepository(ApplicationContext springContainer) {
		ProductRepository repo=springContainer.getBean(ProductRepository.class);
		repo.save(new Product("test222",100002.78,5,"someUrl"));
		repo.findByName("test").stream().forEach(System.out::println);
	}

	private static void testReviewQuries(ApplicationContext springContainer) {
		ReviewService service=springContainer.getBean(ReviewServiceImpl.class);
		
			
	}
	private static void testProductQuries(ApplicationContext springContainer) {
		ProductDAO service=springContainer.getBean(ProductDAOJPAImpl.class);
		List<Product> list=service.findByName("test");
		list.stream().forEach(System.out::println);
		
		
	}
	public static Review readData() {
		try (Scanner s=new Scanner(System.in)) { 
			System.out.print("Enter reviewe name: ");
			String name=s.nextLine();
			System.out.print("Enter reviewe details: ");
			String detail=s.nextLine();
			System.out.print("Enter reviewe rating: ");
			int rating=Integer.parseInt(s.nextLine());
			return new Review(name,detail,rating);
	
		}
	}

}
