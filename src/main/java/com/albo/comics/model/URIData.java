package com.albo.comics.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Configuration
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class URIData {
	
	@Value("${ts}")
	private String ts;
	
	@Value("${puMIdentifier}")
    private String pkPu;
	
	@Value("${prMIdentifier}")
    private String pkPr;
	
	@Value("${marvelAPIURL}")
	private String BaseURI;
	
	@Value("${endPointCharacter}")
	private String characters;
	
	@Value("${endPointComics}")
	private String comics;
	
	@Value("${idIroman}")
	private String idIroman;
	
	@Value("${idCapAmerica}")
	private String idCapAmerica;
	
}
