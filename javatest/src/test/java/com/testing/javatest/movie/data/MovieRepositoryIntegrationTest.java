package com.testing.javatest.movie.data;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

public class MovieRepositoryIntegrationTest {

	@Test
	public void load_all_movies() throws SQLException {
		
		DataSource dataSource = new
								DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
		
		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
		
		Collection<Movie> movies =  movieRepository.findAll();
		
		assertThat(movies, is(Arrays.asList(
					new Movie(1, "Dark Knight",152,Genre.ACTION),
					new Movie(2, "Memento",113,Genre.THILLER),
					new Movie(3, "Matrix",136,Genre.ACTION)
				)));
	}
	
} 
