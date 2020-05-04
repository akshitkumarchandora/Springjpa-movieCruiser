package com.cognizant.moviecruiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
public class MovieSpringDataJpaHibernateApplication {
	@Autowired
	private static MovieService movieService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieSpringDataJpaHibernateApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context=SpringApplication.run(MovieSpringDataJpaHibernateApplication.class, args);
		movieService=context.getBean(MovieService.class);
		testGetMovieAdmin();
		testGetMovieCustomer();
		testGetMovie(1);
		
		//testModifyMovie();
	}
	private static void testModifyMovie()//use this test to insert or update Movie Object
	{
		//Movie movie=movieService.getMovie(1l);
		Movie movie=new Movie();
		movie.setId(1l);
		movie.setTitle("The Silent Voice");
		movie.setBoxOffice("$20 Million");
		movie.setHasTeaser(true);
		movie.setActive(true);
		movie.setDateOfLaunch(DateUtil.convertToDate("12/05/2017"));
		movie.setGenre("Anime");
		movieService.modifyMovie(movie);
		
	}
	private static void testGetMovieAdmin()
	{
		LOGGER.info("Start");	
		LOGGER.debug("Movies :: {}",movieService.getMovieListAdmin());
		LOGGER.info("End");
	}
	
	private static void testGetMovieCustomer()
	{
		LOGGER.info("Start");	
		LOGGER.debug("Movies for customer :: {}",movieService.getMovieListCustomer());
		LOGGER.info("End");
	}
	
	
	private static void testGetMovie(long id)
	{
		LOGGER.info("Start");	
		LOGGER.debug("Item:: {}",movieService.getMovie(id));
		LOGGER.info("End");
	}
	
	

}
