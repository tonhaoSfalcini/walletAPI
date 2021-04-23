package com.wallet.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wallet.entities.User;
import com.wallet.respositories.UserRepository;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class UserRepositoryTest {

	private static final String EMAIL = "email@domain.com";
	
	@Autowired
	UserRepository repository;
	
	@BeforeAll
	public void setUp() {
		User user = new User(null, "Deafult User", "654321", EMAIL);
		repository.save(user);
	}
	
	@AfterAll
	public void tearDown() {
		repository.deleteAll();
	}
	
	
	@Test
	public void testSave() {
		User user = new User(null, "TesteNome", "123456", "teste@teste.com");
		User response = repository.save(user);
		
		assertNotNull(response);
	}
	
	@Test
	public void findByEmail() {
		User user = repository.findByEmail(EMAIL).orElse(null);
		
		assertNotNull(user.getEmail());
		assertEquals(user.getEmail(), EMAIL);
	}
	
}