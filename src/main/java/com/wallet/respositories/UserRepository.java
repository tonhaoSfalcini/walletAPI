package com.wallet.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	Optional<User>  findByEmailEquals(String email);
	
}
