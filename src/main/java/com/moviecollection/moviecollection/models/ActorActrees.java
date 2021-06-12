package com.moviecollection.moviecollection.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="actor_actrees")
@JsonIgnoreProperties(value = { "castRef" })
public class ActorActrees {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name="surname")
	 private String surname;
	 
	 @Column(name="role")
	 private String role;
	 
	 @OneToMany(fetch=FetchType.LAZY, mappedBy= "cast")
	 private Set<Movie> playedIn = new HashSet<>();
	 
	 ActorActrees(){}

	public ActorActrees(Long id, String name, String surname, String role) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	 
	@Override
	public String toString() {
		return "Actor [actor_id=" + id + ", actor_name=" + name + "]";
	}
}
