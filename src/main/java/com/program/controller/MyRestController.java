package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.program.model.Movie;
import com.program.service.MovieService;

@RestController
public class MyRestController {

	@Autowired
	MovieService service;

	@GetMapping("/movies/{Id}")
	private ResponseEntity<Movie> get(@PathVariable("Id") String Id) {
		return service.getMovieById(Integer.parseInt(Id));
	}

	@GetMapping("/movies")
	private ResponseEntity<List<Movie>> get() {
		return service.getAllMovies();
	}

	@PostMapping("/movies")
	private ResponseEntity<?> add(@RequestBody Movie movie) {
		return service.createMovie(movie);
	}

	@PutMapping("/movies/{Id}")
	private ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable("Id") String Id) {
		return service.updateMovie(movie, Integer.parseInt(Id));
	}

	@DeleteMapping("/movies/{Id}")
	private ResponseEntity<?> delete(@PathVariable("Id") String Id) {
		return service.deleteMovie(Integer.parseInt(Id));
	}
}
