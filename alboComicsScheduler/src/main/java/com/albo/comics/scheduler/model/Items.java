package com.albo.comics.scheduler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for Items.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class Items {

  /**
   * Items resourcesUri.
   *
   * @param resourceUri Items resource uri.
   * @return Items resource uri.
   */
  @JsonProperty("resourceURI")
	private String resourceUri;
  
  /**
   * Items name.
   *
   * @param name Items name.
   * @return Items name.
   */
	private String name;
	
	/**
   * Items role.
   *
   * @param name Items role.
   * @return Items role.
   */
	private String role;
	
	@Override
	public String toString() {
	  
		return
		  "Items [resourceURI=" + resourceUri +
		  ", name=" + name +
		  ", role=" + role + "]";
		
	}
	
}
