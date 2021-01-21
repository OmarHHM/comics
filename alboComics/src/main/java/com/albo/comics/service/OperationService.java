package com.albo.comics.service;

import java.util.concurrent.ExecutionException;

import com.albo.comics.model.Heroe;
import com.albo.comics.util.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Methods available to obtain the information of an {@link Hero}.
 */
public interface OperationService {

  /**
   * Method to retrieve collaborators by hero.
   * 
   * @param heroe Name of the hero.
   * 
   * @return An instance of the type {@link Heroe} with the information related.
   * 
   * @throws JsonMappingException
   * @throws JsonProcessingException
   * @throws InterruptedException
   * @throws ExecutionException
   * @throws ApiException
   */
	public Heroe getCollaborators(final String hero) throws JsonMappingException,
	                                                        JsonProcessingException,
	                                                        InterruptedException,
	                                                        ExecutionException,ApiException;
	
	/**
   * Method to retrieve characters by hero.
   * 
   * @param heroe Name of the hero.
   * 
   * @return An instance of the type {@link Heroe} with the information related.
   * 
   * @throws JsonMappingException
   * @throws JsonProcessingException
   * @throws InterruptedException
   * @throws ExecutionException
   * @throws ApiException
   */
	public Heroe getCharacters(final String hero) throws JsonMappingException,
	                                                     JsonProcessingException,
                                                       InterruptedException,
                                                       ExecutionException,
                                                       ApiException;
	
}
