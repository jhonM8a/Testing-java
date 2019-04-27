/**
 * 
 */
package com.testing.javatest.movie.data;

import java.util.Collection;

import com.testing.javatest.movie.model.Movie;

/**
 * Clase para el acceso a datos de Movie.
 * 
 * @author sumel
 *
 */
public interface MovieRepository {

	Movie finById(long id);
	
	Collection<Movie> findAll();
	
	void saveOrUpdate(Movie movie);
}

