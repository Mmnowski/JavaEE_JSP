package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.servletjspdemo.domain.Movie;
import com.example.servletjspdemo.domain.Movie.Genre;

public class StorageService {
	
	private List<Movie> db = new ArrayList<Movie>();
	
	public void add(Movie movie){
		String movieTitle = movie.getTitle();
		for (Movie movieCheck : db) {
			if (movieCheck.getTitle().equals(movieTitle)) {
				System.out.println("Movie called: " + movieTitle + " already exists.");
				return;
			}
		}
		Movie newMovie = new Movie(movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getAmount(), movie.getPrice());
		db.add(newMovie);
	}

	public double rentMovie(String name, int amount) {
		for (Movie movie : db) {
			if (movie.getTitle().equals(name)) {
				if(movie.getAmount() == 0 || movie.getAmount() < amount){
					return 0.0;
				}

				movie.rentMovie(amount);
				System.out.println("Added " + name + " to your basket.");
				return movie.getPrice();
			}
		}
		return 0.0;
	}

	public List<Movie> getAllMovies(){
		return db;
	}
	
    public void generateMovies() {
        if (db.size() == 0) {
        	Movie newMovie1 = new Movie("Zemsta Arka", "Arkadiusz Klein", Genre.Thriller, 5, 12.99);
        	Movie newMovie2 = new Movie("Przygody w krainie Yii", "Robert Fidytek", Genre.Horror, 8, 22.99);
        	Movie newMovie3 = new Movie("Nieistniejacy film II", "Jan Nowak", Genre.Action, 11, 15.00);
        	Movie newMovie4 = new Movie("Nieistniejacy film", "Jan Nowak", Genre.Action, 2, 8.99);
        	Movie newMovie5 = new Movie("Projekt zespolowy", "Pawel Stankiewicz", Genre.Comedy, 123, 6.69);
            db.add(newMovie1);
            db.add(newMovie2);
            db.add(newMovie3);
            db.add(newMovie4);
            db.add(newMovie5);
        }
    }

}
