package com.moviecollection.moviecollection.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.moviecollection.moviecollection.models.User;

public class CustomUserDetails implements UserDetails {
	
	@Autowired
	private User user;
	
	public CustomUserDetails(User user) {
	        this.user = user;
	}
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEpost();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
    public String getFullName() {
    	return user.getName() + " " + user.getSurname();
	}

}
