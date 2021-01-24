package com.albo.comics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albo.comics.model.Response;
import com.albo.comics.service.HeroService;
import com.albo.comics.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@Api(tags = "Marvel SuperHeroes")
public class ApiController {

	private static final Logger LOGGER = LoggerFactory
                                        .getLogger(ApiController.class);

	@Autowired
	private HeroService heroService;    
	@RequestMapping(
	  value  = {"characters/{name}"},
	  method = RequestMethod.GET)
  @ApiOperation(
    value = "Fetches lists of characters.",
    notes = "Fetches lists of comic characters related with superheroes (Iro Man and Captain America).")
  public ResponseEntity getCharacters(@ApiParam(value = "Parametrs valid: {"+
                                                  Constants.IRONMAN+", "+
		                                          Constants.CAPAMERICA+"}") 
                                      @PathVariable String name ) {
	  
		final var response = new Response();
		if (!name.equals(Constants.IRONMAN) &&
		    !name.equals(Constants.CAPAMERICA)) {  
			LOGGER.info("Parametros requerido o no permitidos.");
			return 
			  ResponseEntity
			    .badRequest()
			      .body(response
			    		  .setCode("400")
			    		  .setMessage("Parametros requeridos."));
			
		}
		
		  
		final var result = heroService
		                     .getCharacters(name);			
		
		if(null == result) {
			LOGGER.info("No existe información consultada personaje:",name);
			return
				ResponseEntity
				  .ok(response
						  .setCode("0")
						  .setMessage("No existe información sobre la consulta."));
		}
		
		response
	    .setHero(result);
		
		return
		  ResponseEntity
		    .ok(response
		    		.setCode("0")
		    		.setMessage("Consulta Exitosa."));
	}
	
	@RequestMapping(
	  value  = {"colaborators/{name}"},
	  method = RequestMethod.GET)
  @ApiOperation(
    value = "Fetches lists of editors,writers and colorists of comic.",
    notes = "Fetches lists of editors,writers and colorists of comic "+
            "related with Iro Man or Captain America." )
  public ResponseEntity getColaborators(@ApiParam(value = "Parametrs valid: {"+
                                                    Constants.IRONMAN+", "+
		                                            Constants.CAPAMERICA+"}") 
    		                            @PathVariable String name ) {
		final var response = new Response();				  		
		if (!name.equals(Constants.IRONMAN) &&
		    !name.equals(Constants.CAPAMERICA)) {
			LOGGER.info("Falta parámetro requerido o se ha mandado el dato erroneo {param} ",name);
			return 
			  ResponseEntity
			    .badRequest()
			      .body(response
			    		  .setCode("400")
		    		      .setMessage("Parámetro incorrecto."));
		}
		
		final var result = heroService
		                     .getCollaborators(name);
			

		if(null == result) {
			
			LOGGER.info("No existe información consultada {personaje} ",name);
			return
				ResponseEntity
				  .ok(response
						  .setCode("0")
						  .setMessage("No existe información sobre la consulta."));
		}
		
		response
		  .setHero(result);					
		return
		  ResponseEntity
		    .ok(response
		    		.setCode("0")
		    		.setMessage("Consulta Exitosa."));		
	}	
}
