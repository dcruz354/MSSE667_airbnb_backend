/**
 * 
 */
package com.airbnbBackend.rental.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Dcruz
 *
 */
@Document(collection = "listingsAndReviews")
public class Listing {
	@Id private String id;
	
	@Field("listing_url")
	private String listingUrl;
	private String name;
	private String summary;
	private String descrition;
	@Field("property_type")
	private String propertyType;
	
	public String getListingUrl() {
		return listingUrl;
	}
	public void setListingUrl(String listingUrl) {
		this.listingUrl = listingUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
