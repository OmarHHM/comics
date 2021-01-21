package com.albo.comics.service;

import java.util.concurrent.ExecutionException;

import com.albo.comics.model.Heroe;
import com.albo.comics.util.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface OperationService {

	public Heroe getColaboratos(String heroe) 
			throws JsonMappingException, JsonProcessingException,
                   InterruptedException, ExecutionException,ApiException;
	public Heroe getCharacters(String heroe) 
			throws JsonMappingException, JsonProcessingException,
                   InterruptedException, ExecutionException,ApiException;
}
