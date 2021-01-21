package com.albo.comics.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for Creators.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class Creators {

  /**
   * Creators available.
   *
   * @param available Creators available.
   * @return Creators available.
   */
	private String available;
	
	/**
   * Creators collectionUri.
   *
   * @param collectionUri Creators collectionUri.
   * @return Creators collectionUri.
   */
	@JsonProperty("collectionURI")
	private String collectionUri;
	
	/**
   * Creators items.
   *
   * @param items Creators items.
   * @return Creators items.
   */
	private List<Items> items;
	
	/**
   * Creators returned.
   *
   * @param items Creators returned.
   * @return Creators returned.
   */
	private String returned;
	
	@Override
	public String toString() {
	  
		return
		  "Creators [available=" + available + 
		  ", collectionURI=" + collectionUri + 
		  ", items=" + items +
		  ", returned=" + returned + "]";
		
	}
	
}
