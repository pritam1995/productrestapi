package com.pritam.productrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.pritam.productrestapi.entities.Product;

import static org.junit.Assert.*;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	void testGetProduct() {

		RestTemplate restTeamplate = new RestTemplate();
		Product product = restTeamplate.getForObject(baseURL + "1", Product.class);
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("Smartphone");
		product.setPrice(100.00);
		Product newProduct = restTemplate.postForObject(baseURL, product,
				Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung", newProduct.getName());
	}

	@Test
	void testUpdateProduct() {

		RestTemplate restTeamplate = new RestTemplate();
		Product product = restTeamplate.getForObject(baseURL + "1", Product.class);
		product.setPrice(1200.00);

		restTeamplate.put(baseURL, product);
	}

}
