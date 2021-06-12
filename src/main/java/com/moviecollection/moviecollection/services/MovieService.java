package com.moviecollection.moviecollection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecollection.moviecollection.models.Movie;
import com.moviecollection.moviecollection.repositories.MovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}
	
	@Override
	public List<Movie> getAllMovies() {
		
		return movieRepository.findAll();
	}


	@Override
	public Movie getMovieById(Long id) {
		
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		Movie movie = null;
		if(optionalMovie.isPresent()) {
			movie = optionalMovie.get();
		}
		else {
			throw new RuntimeException("Movie not found for id id: " + id);
		}
		return movie;
	}

	@Override
	public void deleteMovie(Long id) {
		
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> GetMovies(String keyword) {
			return movieRepository.search(keyword);
	}

	@Override
	public List<Movie> orderByAscending() {
		
		return movieRepository.orderByAscending();
	}

	@Override
	public Movie updateMovie(Movie newMovie, Long id) {
		
		return movieRepository.findById(id)
				.map(movie -> {
					movie.setName(newMovie.getName());
					movie.setDescription(newMovie.getDescription());
					movie.setImagePath(newMovie.getImagePath());
					movie.setLanguage(newMovie.getLanguage());
					movie.setPubYear(newMovie.getPubYear());
					movie.setType(newMovie.getType());
					movie.setActorActress(newMovie.getActorActress());
					return movieRepository.save(movie);
				}).orElseGet(() -> {
					newMovie.getId();
					return movieRepository.save(newMovie);
				});
	}

	@Override
	public Movie createMovie(Movie newMovie) {
		return movieRepository.save(newMovie);
	}
	
	public Movie get(Long id) {
		return movieRepository.findById(id).get();
	}

}
