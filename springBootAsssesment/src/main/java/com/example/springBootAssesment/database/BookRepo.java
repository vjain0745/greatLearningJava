package com.example.springBootAssesment.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootAssesment.entity.Books;

public interface BookRepo extends JpaRepository<Books, String> {

	Books findByAuthorId(String authorId);
	
	
	
	List<Books> findByPriceGreaterThanEqual(int startPrice);
	List<Books> findByPriceLessThanEqual(int startPrice);
	List<Books> findAllByOrderByPriceAsc();
	List<Books> findAllByOrderByPriceDesc();
	

}
