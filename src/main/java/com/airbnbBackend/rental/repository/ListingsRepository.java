package com.airbnbBackend.rental.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.airbnbBackend.rental.domain.Listing;

@RepositoryRestResource(collectionResourceRel = "listingsAndReviews", path = "listingsAndReviews")
public interface ListingsRepository extends MongoRepository<Listing, String> {
	
	//http://localhost:8080/listingsAndReviews/search/findByPropertyType?name=House
	List<Listing> findByPropertyType(String name);
	
	//http://localhost:8080/listingsAndReviews/search/findByName?name=Test2
	Listing findByName(String name);
}
