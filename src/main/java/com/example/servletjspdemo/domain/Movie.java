package com.example.servletjspdemo.domain;

public class Movie {
	
	private String title;
	public enum Genre {
		Action, Horror, Comedy, Thriller
	}
	private Genre genre;
	private String director;	
	private int amount;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, String director, Genre genre, int amount) {
		this.title = title;
		this.director = director;		
		this.genre = genre;
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre gen) {
		genre = gen;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmmount(int amount) {
		this.amount = amount;
	}
	
}