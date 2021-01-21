package com.albo.comics.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterModel {
	
	  @Id
	  private Integer id;
	  private String name;
	  private String[] comics;
	  
	@Override
	public String toString() {
		return "CharacterModel [id=" + id + ", name=" + name + ", comics=" + Arrays.toString(comics) + "]";
	}
	  
	 
}
