package com.moviecollection.moviecollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moviecollection.moviecollection.models.Movie;
import com.moviecollection.moviecollection.repositories.MovieRepository;
import com.moviecollection.moviecollection.services.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/movies")
	public String getAllMovies(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("getMovies", movieService.GetMovies(keyword));
		}
		else {
			model.addAttribute("getMovies", movieService.getAllMovies());
		}
		
		
		
		return "movie_home";
	}
	
	@GetMapping("/adminMovies")
	public String getMovies(Model model, @Param("keyword") String keyword) {
		
		if(keyword != null) {
			model.addAttribute("getMovies", movieService.GetMovies(keyword));
		}
		else {
			model.addAttribute("getMovies", movieService.getAllMovies());
		}
		
		return "admin_movie";
	}
	
	@GetMapping("/movieSortByYear")
	public String sortByYear(Model model) {
		model.addAttribute("getMovies", movieService.orderByAscending());

		return "movie_home";
	}
	
	@GetMapping("/newMovie")
	public String createMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		
		return "create_movie";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(Movie movie,  BindingResult result, Model model) {
		
		 if (result.hasErrors()) {
	            return "create_movie";
	        }
		
	  movieRepository.save(movie);
	     
	    return "movie_success";
	}
	
	@GetMapping("/updateMovie/{id}")
	public ModelAndView updateMovie(@PathVariable(name = "id") Long id) {
		 ModelAndView mav = new ModelAndView("update_movie");
		 Movie movie = movieService.get(id);
		 
		 mav.addObject("movie", movie);
		 
		 return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteMovie(@PathVariable(name = "id") Long id) {
		movieService.deleteMovie(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/infoMovie/{id}")
	public String infoMovie(@PathVariable(value = "id") Long id, Model model) {

		// get movie from the service
		Movie movie = movieService.getMovieById(id);

		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		return "info_movie";
	}
	
	@GetMapping("/adminInfoMovie/{id}")
	public String adminInfoMovie(@PathVariable(value = "id") Long id, Model model) {

		// get movie from the service
		Movie movie = movieService.getMovieById(id);

		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		return "admin_info";
	}
}
