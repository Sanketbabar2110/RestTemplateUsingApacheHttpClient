package com.program.model;

public class Movie {

	private int Id;
	private int releaseDate;
	private String movie_name;

	public Movie() {
		super();
	}

	public Movie(int id, int releaseDate, String movie_name) {
		super();
		Id = id;
		this.releaseDate = releaseDate;
		this.movie_name = movie_name;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", releaseDate=" + releaseDate + ", movie_name=" + movie_name + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
}
