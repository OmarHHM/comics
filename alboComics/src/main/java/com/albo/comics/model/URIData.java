package com.albo.comics.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for URIData.
*/
@Configuration
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
public class URIData {
	
  /**
   * URIData ts.
   *
   * @param ts URIData ts.
   * @return URIData ts.
   */
	@Value("${ts}")
	private String ts;
	
	/**
   * URIData pkPu.
   *
   * @param pkPu URIData pkPu.
   * @return URIData pkPu.
   */
	@Value("${puMIdentifier}")
  private String pkPu;
	
	/**
   * URIData pkPr.
   *
   * @param pkPr URIData pkPr.
   * @return URIData pkPr.
   */
	@Value("${prMIdentifier}")
  private String pkPr;
	
	/**
   * URIData BaseURI.
   *
   * @param BaseURI URIData BaseURI.
   * @return URIData BaseURI.
   */
	@Value("${marvelAPIURL}")
	private String BaseURI;
	
	/**
   * URIData characters.
   *
   * @param characters URIData characters.
   * @return URIData characters.
   */
	@Value("${endPointCharacter}")
	private String characters;
	
	/**
   * URIData comics.
   *
   * @param comics URIData comics.
   * @return URIData comics.
   */
	@Value("${endPointComics}")
	private String comics;

  /**
   * URIData idIroman.
   *
   * @param idIroman URIData idIroman.
   * @return URIData idIroman.
   */
	@Value("${idIroman}")
	private String idIroman;
	
	/**
   * URIData idCapAmerica.
   *
   * @param idCapAmerica URIData idCapAmerica.
   * @return URIData idCapAmerica.
   */
	@Value("${idCapAmerica}")
	private String idCapAmerica;
	
	@Override
  public String toString() {
	  
    return
      "URIData [ts=" + ts +
      ", pkPu=" + pkPu +
      ", pkPr=" + pkPr +
      ", BaseURI=" + BaseURI +
      ", characters=" + characters +
      ", comics=" + comics +
      ", idIroman=" + idIroman +
      ", idCapAmerica=" + idCapAmerica + "]";
    
  }
	
}
