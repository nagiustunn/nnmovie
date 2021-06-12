package com.moviecollection.moviecollection.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.moviecollection.moviecollection.models.Movie;

public interface IMovieService {
	
	List<Movie> getAllMovies();

	Movie getMovieById(Long id);

	void deleteMovie(Long id);

	List<Movie> GetMovies(String keyword);

	public List<Movie> orderByAscending();
	
	Movie updateMovie(@RequestBody Movie newMovie, @PathVariable Long id);
	
	Movie createMovie(@RequestBody Movie newMovie);
	
	

}
