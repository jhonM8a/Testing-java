package com.testing.javatest.movie.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.mockito.Mockito;

import com.testing.javatest.movie.data.MovieRepository;
import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

public class MovieServiceTest {

	@Test
	public void return_movies_by_genre() {
		
		MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
		
		Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
						new Movie(1,"Pelicula 1", 200, Genre.ACTION),
						new Movie(2,"Pelicula 1", 200, Genre.THILLER),
						new Movie(3,"Pelicula 1", 200, Genre.COMEDY),
						new Movie(4,"Pelicula 1", 200, Genre.THILLER),
						new Movie(5,"Pelicula 1", 200, Genre.HORROR),
						new Movie(6,"Pelicula 1", 200, Genre.COMEDY),
						new Movie(7,"Pelicula 1", 200, Genre.ACTION)));
		
		MovieService movieService = new MovieService(movieRepository);
		
		Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
		//Dado la coleccion de movies, se optienen los id se pasan a una lista
		List<Integer> moveIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
		
		assertThat(moveIds, is(Arrays.asList(3,6)));
	}

}
