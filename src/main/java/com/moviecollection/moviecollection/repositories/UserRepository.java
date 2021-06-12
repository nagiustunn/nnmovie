package com.moviecollection.moviecollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moviecollection.moviecollection.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.epost = ?1")
    public User findByEmail(String email);
}
