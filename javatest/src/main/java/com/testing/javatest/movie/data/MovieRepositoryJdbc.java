/**
 * 
 */
package com.testing.javatest.movie.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.testing.javatest.movie.model.Genre;
import com.testing.javatest.movie.model.Movie;

/**
 * Implementación de repositorio para movies
 * 
 * @author sumel
 *
 */
public class MovieRepositoryJdbc implements MovieRepository {
	
	private JdbcTemplate jdbcTemplate;

	public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie finById(long id) {
		
		Object[] args = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM MOVIES WHERE ID = ?", args, movieMapper);
	}

	@Override
	public Collection<Movie> findAll() {
		

		return jdbcTemplate.query("select * from movies", movieMapper);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		jdbcTemplate.update("insert into movies (name, minutes, genre) values (?,?,?)", movie.getName(),
				movie.getMinutes(), movie.getGenre().toString());
		
	}
	
	private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Movie(
					rs.getInt("id"),
					rs.getString("name"), 
					rs.getInt("minutes"),
					Genre.valueOf(rs.getString("genre"))
					);
		}
	} ;

}
