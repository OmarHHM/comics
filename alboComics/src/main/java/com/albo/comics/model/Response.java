package com.albo.comics.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for Response.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
  
  /**
   * Response code.
   *
   * @param code Response code.
   * @return Response code.
   */
	private String code;
	
	/**
   * Response message.
   *
   * @param message Response message.
   * @return Response message.
   */
	private String message;
	
	/**
   * Response hero.
   *
   * @param hero Response hero.
   * @return Response hero.
   */
	@JsonProperty("data")
	private Hero hero;

  @Override
  public String toString() {
    
    return
      "Response [code=" + code +
      ", message=" + message + 
      ", hero=" + hero + "]";
  }
	
}
