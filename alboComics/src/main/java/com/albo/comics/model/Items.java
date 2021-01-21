package com.albo.comics.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class Items {

	private String resourceURI;
	private String name;
	private String role;
	@Override
	public String toString() {
		return "Items [resourceURI=" + resourceURI + ", name=" + name + ", role=" + role + "]";
	}
	
}
