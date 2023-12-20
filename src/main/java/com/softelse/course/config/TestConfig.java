package com.softelse.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softelse.course.entities.Category;
import com.softelse.course.entities.Order;
import com.softelse.course.entities.Product;
import com.softelse.course.entities.User;
import com.softelse.course.entities.enums.OrderStatus;
import com.softelse.course.repositories.CategoryRepository;
import com.softelse.course.repositories.OrderRepository;
import com.softelse.course.repositories.ProductRepository;
import com.softelse.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired	
	private UserRepository userRepository;
	
	@Autowired	
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Arroz Doce", "ArrozDoce@gmail.com", "98765433", "1234567");
		User u2 = new User(null,"Pamonha Doce", "PamonhaDoce@gmail.com", "98451234", "6789456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		Category c1 = new Category (null, "Sobremesa");
		Category c2 = new Category (null, "Entrada");
		Category c3 = new Category (null, "Prato Principal");
		
		Product p1 = new Product (null, "Panqueca", "Prato Sobremesa", 7.50, "http:aaaaa.com");
		Product p2 = new Product (null, "Picanha", "Prato Principal", 77.50, "http:aaaaa.com");
		Product p3 = new Product (null, "Batata Frita", "Prato Entrada", 7.50, "http:aaaaa.com");
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}
	
}
