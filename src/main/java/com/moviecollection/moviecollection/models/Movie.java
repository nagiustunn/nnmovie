package com.moviecollection.moviecollection.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movie")
@JsonIgnoreProperties(value = { "castRef" })
public class Movie {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name="type")
	 private String type;
	 
	 @Column(name="pub_year")
	 private Date pubYear;
	 
	 @Column(name="description")
	 private String description;
	 
	 @Column(name="language")
	 private String language;
	 
	 @Column(name="image_path")
	 private String imagePath;
	 
	 @Column(name="actor_actress")
	 private String actorActress;
	 
	 @OneToMany(fetch = FetchType.LAZY)
		@JoinTable(
				name = "movie_actors",
				joinColumns = @JoinColumn(name="movie_id"),
				inverseJoinColumns = @JoinColumn(name="actor_actrees_id")
		)
		private Set<ActorActrees> cast = new HashSet<>();
	 
	 public Movie(){}

	

	public Movie(Long id, String name, String type, Date pubYear, String description, String language, String imagePath,
			String actorActress, Set<ActorActrees> cast) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.pubYear = pubYear;
		this.description = description;
		this.language = language;
		this.imagePath = imagePath;
		this.actorActress = actorActress;
		this.cast = cast;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPubYear() {
		return pubYear;
	}

	public void setPubYear(Date pubYear) {
		this.pubYear = pubYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	 
	
	public String getActorActress() {
		return actorActress;
	}



	public void setActorActress(String actorActress) {
		this.actorActress = actorActress;
	}



	@Override
	public String toString() {
		String castString = "";
		for (ActorActrees actorActrees : this.cast) {
			castString += actorActrees.toString();
		}
		
		return "Movie [id=" + id + ", name=" + name + ", date=" + pubYear + ", category=" + type + ", description="
				+ description + ", language	=" + language + ", cast=" + castString + "]";
	}
}
