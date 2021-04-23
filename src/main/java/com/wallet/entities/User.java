package com.wallet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Entity(name = "tb_user") 
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter @Setter @Column(nullable = false)
	private String nome;

	@Getter @Setter @Column(nullable = false)
	private String senha;
	
	@Getter @Setter @Column(nullable = false)
	private String email;
	
}
