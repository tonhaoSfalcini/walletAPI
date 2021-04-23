package com.wallet.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entities.User;
import com.wallet.respositories.UserRepository;
import com.wallet.services.UserService;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@BeforeAll
	public void setUp() {
		BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> user = userService.findByEmail("user@domain.com");
	}
	
}
