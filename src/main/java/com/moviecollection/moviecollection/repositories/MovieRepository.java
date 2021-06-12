package com.moviecollection.moviecollection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moviecollection.moviecollection.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT movie FROM Movie movie WHERE movie.name LIKE %:keyword% OR movie.name LIKE %:keyword% OR movie.type LIKE %:keyword% OR movie.actorActress LIKE %:keyword%")
	public List<Movie> search(@Param("keyword") String keyword);

	@Query("from Movie order by pubYear asc")
	public List<Movie> orderByAscending();
}
