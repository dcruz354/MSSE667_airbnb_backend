package com.airbnbBackend.rental.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.airbnbBackend.rental.domain.Listing;

@RepositoryRestResource(collectionResourceRel = "listingsAndReviews", path = "listingsAndReviews")
public interface ListingsRepository extends MongoRepository<Listing, String> {
	
	List<Listing> findByPropertyType(String name);
	Listing findByName(String name);
}
