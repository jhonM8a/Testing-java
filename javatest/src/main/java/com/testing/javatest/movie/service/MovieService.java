/**
 * 
 */
package com.testing.javatest.movie.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.testing.javatest.movie.data.MovieRepository;
import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

/**
 * Clase para lo logica de negocio de peliculas(Movie)
 * 
 * @author sumel
 *
 */
public class MovieService {
	
	private MovieRepository movieRepository;

	
	public MovieService(MovieRepository movieRepository) {
		
		this.movieRepository = movieRepository;
	}


	public Collection<Movie> findMoviesByGenre(Genre genre) {
		 
		Collection<Movie> allMovies = movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
				.collect(Collectors.toList());
		 
		 
		 return allMovies;
		
	}


	public Collection<Movie> findMoviesByLength(int length) {
		return  movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length)
				.collect(Collectors.toList());
	}


	public Collection<Movie> findByName(String nameMovie) {
		
		
		return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(nameMovie.toLowerCase()))
				.collect(Collectors.toList());
	}

}
