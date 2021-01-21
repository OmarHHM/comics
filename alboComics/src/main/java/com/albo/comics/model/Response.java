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
   * Response heroe.
   *
   * @param heroe Response heroe.
   * @return Response heroe.
   */
	@JsonProperty("data")
	private Heroe heroe;

  @Override
  public String toString() {
    
    return
      "Response [code=" + code +
      ", message=" + message + 
      ", heroe=" + heroe + "]";
  }
	
}
