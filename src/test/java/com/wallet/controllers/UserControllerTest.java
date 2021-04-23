package com.wallet.controllers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.entities.User;
import com.wallet.services.UserService;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

	private static final String NOME = "User Test";
	private static final String EMAIL = "user@domain.com";
	private static final String SENHA = "123456";
	private static final String URL = "user";
	
	@MockBean
	UserService userService;
	
	@Autowired
	MockMvc mockMvc;
	
	
	public void testSave() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post(URL).content(getJsonPayload())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	public User getMockUser() {
		User user = new User(null, NOME, SENHA, EMAIL);
		
		return user;
	}
	
	public String getJsonPayload() {
		UserDTO = dto = new UserDTO();
		dto.setNome(NOME);
		dto.setSenha(SENHA);
		dto.setEmail(EMAIL);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
	}
}
