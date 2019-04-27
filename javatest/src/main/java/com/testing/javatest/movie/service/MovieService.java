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
		 
		Collection<Movie> allMovies =  movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
		 
		 
		 return allMovies;
		
	}

}
