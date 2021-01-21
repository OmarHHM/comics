package com.albo.comics.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.albo.comics.model.Heroe;
import com.albo.comics.model.Response;
import com.albo.comics.service.OperationService;
import com.albo.comics.util.ApiException;
import com.albo.comics.util.Constants;
import com.albo.comics.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@Api(tags = "Marvel SuperHeroes")
public class ApiController {

	
	@Autowired
	private OperationService operationService;    

	
	@RequestMapping(value={"characters/{name}"},method = RequestMethod.GET)
    @ApiOperation(value = "Fetches lists of characters.", notes = "Fetches lists of comic characters related with superheroes (Iro Man and Captain America)." )
    public ResponseEntity getCharacters(
    		@ApiParam(value = "Parametrs valid: {"+Constants.IROMAN+", "+Constants.CAPAMERICA+"}") 
    		@PathVariable String name ) {
		var response= new Response();
		Heroe result;
		
		if( !name.equals(Constants.IROMAN) && !name.equals(Constants.CAPAMERICA)) {
			return ResponseEntity.badRequest().build();
		}
		try {
			result=operationService.getCharacters(name);
			result.setLast_sync(Util.getDatetime());
			response.setHeroe(result);
			
		} catch (JsonProcessingException | InterruptedException | ExecutionException e) {
			response.setCode("500");
			response.setMessage("Falla en el servicio, consulte al administrador de sistemas.");
		} catch (ApiException e) {
			return ResponseEntity.ok(e.getMessage());
		}
		return ResponseEntity.ok(response);
	}	
		
	
	@RequestMapping(value={"colaborators/{name}"},method = RequestMethod.GET)
    @ApiOperation(value = "Fetches lists of editors,writers and colorists of comic.", notes = "Fetches lists of editors,writers and colorists of comic related with Iro Man or Captain America." )
    public ResponseEntity getColaborators(
    		@ApiParam(value = "Parametrs valid: {"+Constants.IROMAN+", "+Constants.CAPAMERICA+"}") 
    		@PathVariable String name ) {
		
		if( !name.equals(Constants.IROMAN) && !name.equals(Constants.CAPAMERICA)) {
			return ResponseEntity.badRequest().build();
		}
		
		var response= new Response();
		Heroe result;
		try {
			result=operationService.getColaboratos(name);
			result.setLast_sync(Util.getDatetime());
			response.setHeroe(result);
		} catch (JsonProcessingException | InterruptedException | ExecutionException e) {
			response.setCode("500");
			response.setMessage("Falla en el servicio, consulte al administrador de sistemas.");
		} catch (ApiException e) {
			return ResponseEntity.ok(e.getMessage());
		}
		return ResponseEntity.ok(response);
	}
}
