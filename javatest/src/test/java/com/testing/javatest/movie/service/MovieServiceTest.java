package com.testing.javatest.movie.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.testing.javatest.movie.data.MovieRepository;
import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

public class MovieServiceTest {

	private MovieService movieService;

	@Before
	public void setup() {
		MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

		Mockito.when(movieRepository.findAll())
				.thenReturn(Arrays.asList(new Movie(1, "Pelicula 1", 120, Genre.ACTION),
						new Movie(2, "Pelicula 1", 111, Genre.THILLER), new Movie(3, "Pelicula 1", 126, Genre.COMEDY),
						new Movie(4, "Pelicula 1", 123, Genre.THILLER), new Movie(5, "Pelicula 1", 140, Genre.HORROR),
						new Movie(6, "Pelicula 1", 100, Genre.COMEDY), new Movie(7, "Pelicula 1", 180, Genre.ACTION)));

		movieService = new MovieService(movieRepository);
	}

	@Test
	public void return_movies_by_genre() {

		Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

		assertThat(getMoviesIds(movies), is(Arrays.asList(3, 6)));
	}

	@Test
	public void return_movies_by_duration() {
		Collection<Movie> movies = movieService.findMoviesByLength(120);

		assertThat(getMoviesIds(movies), is(Arrays.asList(1, 2, 6)));
	}

	public List<Integer> getMoviesIds(Collection<Movie> movies) {
		// Dado la coleccion de movies, se optienen los id se pasan a una lista
		return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

	}
}
