package com.cognizant.moviecruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	

	@Transactional
	public void modifyMovie(Movie movie)
	{
		LOGGER.info("Start");
		movieRepository.save(movie);
		LOGGER.info("End");
		
	}
	
	@Transactional
	public Movie getMovie(long movieId)
	{
		LOGGER.info("Start");
		return movieRepository.findById(movieId).get();
		
	}
	
	@Transactional
	public List<Movie> getMovieListCustomer()
	{
		LOGGER.info("Start");
	 return movieRepository.findByActiveItems();
	}
	
	@Transactional
	public List<Movie> getMovieListAdmin()
	{
		LOGGER.info("Start");
		return movieRepository.findAll();
	}
	
}
