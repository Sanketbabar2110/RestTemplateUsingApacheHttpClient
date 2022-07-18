package com.program.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.program.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment environment;

	@Override
	public ResponseEntity<Movie> getMovieById(int Id) {

		String base_uri = environment.getRequiredProperty("Base_Uri");
		String final_uri = base_uri.concat("/"+Integer.toString(Id));
		System.out.println(final_uri);

		ResponseEntity<Movie> movie = restTemplate.getForEntity(final_uri, Movie.class);

		return movie;
	}

	@Override
	public ResponseEntity<List<Movie>> getAllMovies() {

		String base_uri = environment.getRequiredProperty("Base_Uri");
		System.out.println(base_uri);

		List<Movie> entity = restTemplate.getForObject(base_uri, List.class);

		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity<?> createMovie(Movie entity) {

		String base_uri = environment.getRequiredProperty("Base_Uri");

		ResponseEntity<String> resp = restTemplate.postForEntity(base_uri, entity, String.class);
		return resp;
	}

	@Override
	public ResponseEntity<?> updateMovie(Movie entity, int Id) {

		String base_uri = environment.getRequiredProperty("Base_Uri");
		String final_uri = base_uri.concat("/"+Integer.toString(Id));
		System.out.println(final_uri);

		ResponseEntity<?> resp = null;
		try {
			restTemplate.put(final_uri, entity);
			resp = ResponseEntity.ok("Movie Details Updated Successfully!!!");
			return resp;
		} catch (Exception e) {
			resp = ResponseEntity.ok("Issue in updating Movie Details!!!");
			return resp;
		}
	}

	@Override
	public ResponseEntity<?> deleteMovie(int Id) {

		String base_uri = environment.getRequiredProperty("Base_Uri");
		String final_uri = base_uri.concat("/"+Integer.toString(Id));
		System.out.println(final_uri);

		ResponseEntity<?> resp = null;
		try {
			restTemplate.delete(final_uri);
			resp = ResponseEntity.ok("Movie Details Deleted Successfully!!!");
			return resp;
		} catch (Exception e) {
			resp = ResponseEntity.ok("Failed to remove Movie details!!!");
			return resp;
		}
	}

}
