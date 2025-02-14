package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	//Jpa Repository will create this automatically using the logic in the 
	//name of the method declaration 
	List<Review> findByCompanyId(Long companyId);

}
