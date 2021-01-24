package com.albo.comics.scheduler.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for a CharacterModel.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterModel {
	
  /**
   * Character model id.
   *
   * @param id Character model id.
   * @return Character model id.
   */
	private Integer id;
	
	/**
   * Character model name.
   *
   * @param name Character model name.
   * @return Character model name.
   */
	private String name;
	
	/**
   * Character model comics.
   *
   * @param comics Character model comics.
   * @return Character model comics.
   */
	private String[] comics;
	  
	@Override
	public String toString() {
	  
		return
		  "CharacterModel [id=" + id +
		  ", name=" + name +
		  ", comics=" + Arrays.toString(comics) + "]";
		
	}
	
}
