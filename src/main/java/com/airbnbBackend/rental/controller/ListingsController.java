/**
 * 
 */
package com.airbnbBackend.rental.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnbBackend.rental.domain.Listing;
import com.airbnbBackend.rental.exception.ResourceNotFoundException;
import com.airbnbBackend.rental.repository.ListingsRepository;

/**
 * @author Dcruz
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/listingsAndReviews/v1")
public class ListingsController {
	
	@Autowired
	ListingsRepository listingsRepository;
	
	// Retrieve all listings
	@GetMapping("/listings")
	public List<Listing> getAllListings() {
		return listingsRepository.findAll();
	}
	
	// Retrieve listing by Id
	@GetMapping("/listings/{id}")
	public ResponseEntity <Listing> getListingById(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found for this id :: " + id));
		return ResponseEntity.ok().body(listing);
	}
	
	
	//Retrieve listing by name
	@GetMapping("listings/propertyName/{name}")
	public ResponseEntity <Listing> getListingByName(@PathVariable(value = "name") String name) {
		Listing listing = listingsRepository.findByName(name);
		return ResponseEntity.ok().body(listing); 
	}
	 
	
	// Create a listing
	@PostMapping("/listings/create")
	public Listing createListing(@RequestBody Listing listing)
	{
		return listingsRepository.save(listing);
	}
	
	// Update a listing by id
	@PutMapping("/listings/update/{id}")
	public ResponseEntity <Listing> updateListing(@PathVariable(value = "id") String id, @RequestBody Listing listingDetails) throws ResourceNotFoundException {
		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found for this id :: " + id));
		
		listing.setDescrition(listingDetails.getDescrition());
		listing.setListingUrl(listingDetails.getListingUrl());
		listing.setName(listingDetails.getName());
		listing.setPropertyType(listingDetails.getPropertyType());
		listing.setSummary(listingDetails.getSummary());
		
		final Listing updatedListing = listingsRepository.save(listing);
		return ResponseEntity.ok().body(updatedListing);
	}
	
	// Delete a listing by id
	@DeleteMapping("/listings/delete/{id}")
	public Map < String, Boolean > deleteListing(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found for this id :: " + id));
		
		listingsRepository.delete(listing);
		Map< String, Boolean> response = new HashMap <> ();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
}
