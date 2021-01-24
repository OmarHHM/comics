package com.albo.comics.service;

import com.albo.comics.model.Hero;

/**
 * Methods available to obtain the information of an {@link Hero}.
 */
public interface HeroService {

  /**
   * Method to retrieve collaborators by hero.
   * 
   * @param hero Name of the hero.
   * 
   * @return An instance of the type {@link Hero} with the information related.
   * 
   */
	public Hero getCollaborators(final String hero);
	
	/**
   * Method to retrieve characters by hero.
   * 
   * @param hero Name of the hero.
   * 
   * @return An instance of the type {@link Hero} with the information related.
   * 
   */
	public Hero getCharacters(final String hero);
	
}
