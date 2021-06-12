package com.moviecollection.moviecollection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.moviecollection.moviecollection.models.User;
import com.moviecollection.moviecollection.repositories.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
	private UserRepository userRepository;
	  
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
	
}