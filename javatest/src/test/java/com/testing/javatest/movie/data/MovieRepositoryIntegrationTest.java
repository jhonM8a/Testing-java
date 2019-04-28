package com.testing.javatest.movie.data;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

public class MovieRepositoryIntegrationTest {
	
	private MovieRepositoryJdbc movieRepository;
	
	private DataSource dataSource;

	@Before
	public void setup() throws SQLException{
		
		dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		 movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
	}

	@Test
	public void load_all_movies()  {

		Collection<Movie> movies = movieRepository.findAll();

		assertThat(movies, is(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION),
				new Movie(2, "Memento", 113, Genre.THILLER), new Movie(3, "Matrix", 136, Genre.ACTION))));
	}

	@Test
	public void load_movi_by_id() {
		
		Movie movie = movieRepository.finById(2);
		
		assertThat(movie, is( new Movie(2, "Memento", 113, Genre.THILLER)));
	}
	

	@Test
	public void insert_a_movie() {
		
		Movie movie = new Movie("El caballo chunki", 113, Genre.THILLER);
		
		movieRepository.saveOrUpdate(movie);
		
		Movie movieLoad = movieRepository.finById(4);
		
		assertThat(movieLoad, is(new Movie(4,"El caballo chunki", 113, Genre.THILLER)));
	}
	
	@After
	public void tearDown() throws SQLException {
		
		final Statement s = dataSource.getConnection().createStatement();
		s.execute("drop all objects delete files");
	}
}
