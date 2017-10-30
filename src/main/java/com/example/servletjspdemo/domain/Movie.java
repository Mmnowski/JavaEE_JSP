package com.example.servletjspdemo.domain;

public class Movie {
	
	private String title;
	public enum Genre {
		Action, Horror, Comedy, Thriller
	}
	private Genre genre;
	private String director;	
	private int amount;
	private double price = 1;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, String director, Genre genre, int amount, double price) {
		this.title = title;
		this.director = director;		
		this.genre = genre;
		this.amount = amount;
		this.price = price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public synchronized void rentMovie(int amount) {
		if (this.amount > 0 && this.amount >= amount) {
			this.amount -= amount;
		}
	}
}