package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value="select * from movie where mo_date_of_launch <=CURRENT_DATE()",nativeQuery = true)
	List<Movie> findByActiveItems();

}
