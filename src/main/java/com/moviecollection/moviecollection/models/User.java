package com.moviecollection.moviecollection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@JsonIgnoreProperties(value = { "castRef" })
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="epost")
	private String epost;
	
	public User(){
		
	}

	public User(Long id, String name, String surname, String password, String epost) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.epost = epost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + id + ", user_name=" + name + ", , user_surname=" + name + "]";
	}
	
}
