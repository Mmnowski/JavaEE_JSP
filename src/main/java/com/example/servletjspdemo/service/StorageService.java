package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.servletjspdemo.domain.Movie;
import com.example.servletjspdemo.domain.Movie.Genre;

public class StorageService {
	
	private List<Movie> db = new ArrayList<Movie>();
	
	public void add(Movie movie){
		Movie newMovie = new Movie(movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getAmount());
		db.add(newMovie);
	}
	
	public List<Movie> getAllMovies(){
		return db;
	}
	
    public void generateMovies() {
        if (db.size() == 0) {
        	Movie newMovie1 = new Movie("Zemsta Arka", "Arkadiusz Klein", Genre.Thriller, 5);
        	Movie newMovie2 = new Movie("Przygody w krainie Yii", "Robert Fidytek", Genre.Horror, 8);
        	Movie newMovie3 = new Movie("Nieistniejacy film 2", "Jan Nowak", Genre.Action, 11);
        	Movie newMovie4 = new Movie("Nieistniejacy film", "Jan Nowak", Genre.Action, 2);
        	Movie newMovie5 = new Movie("Projekt zespołowy", "Pawel Stankiewicz", Genre.Comedy, 123);
            db.add(newMovie1);
            db.add(newMovie2);
            db.add(newMovie3);
            db.add(newMovie4);
            db.add(newMovie5);
        }
    }

}
