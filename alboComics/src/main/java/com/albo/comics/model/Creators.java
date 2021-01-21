package com.albo.comics.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class Creators {

	private String available;
	private String collectionURI;
	private List<Items> items;
	private String returned;
	@Override
	public String toString() {
		return "Creators [available=" + available + ", collectionURI=" + collectionURI + ", items=" + items
				+ ", returned=" + returned + "]";
	}
	
	
	
	
}
