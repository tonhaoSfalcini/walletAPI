package com.wallet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entities.User;
import com.wallet.response.Response;
import com.wallet.services.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Validated @RequestBody UserDTO dto, BindingResult result){
		Response<UserDTO> response = new Response<UserDTO>();
		
		User user = userService.save(convertDtoToEntity(dto));
		response.setData(convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private User convertDtoToEntity(UserDTO dto) {
		User user = new User(null, dto.getName(), dto.getSenha(), dto.getEmail());
		
		return user;
	}
	private UserDTO convertEntityToDto(User user) {
		UserDTO dto = new UserDTO();
		dto.setName(user.getNome());
		dto.setSenha(user.getSenha());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
}
