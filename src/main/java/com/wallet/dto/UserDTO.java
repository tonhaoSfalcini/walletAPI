package com.wallet.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	
	@Length(min = 3, max = 250, message = "Deve conter entre 3 e 250 caracteres")
	@NotNull
	private String name;
	
	@Email(message = "Informe um e-mail válido")
	@NotNull
	private String email;
	
	@Length(min = 8, message = "Deve conter no mínimo 8 caracteres")
	@NotNull
	private String senha;
	
}
