package com.program.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.program.model.Movie;

public interface MovieService {

	public ResponseEntity<Movie> getMovieById(int Id);

	public ResponseEntity<List<Movie>> getAllMovies();

	public ResponseEntity<?> createMovie(Movie entity);

	public ResponseEntity<?> updateMovie(Movie entity, int Id);

	public ResponseEntity<?> deleteMovie(int Id);
}
