package com.albo.comics.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Response {
	private String code;
	private String message;
	@JsonProperty("data")
	private Heroe heroe;
}
