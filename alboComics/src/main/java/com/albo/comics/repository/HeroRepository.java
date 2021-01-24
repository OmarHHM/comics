package com.albo.comics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.albo.comics.model.Hero;

/**
 * Methods available to obtain the information of an {@link Hero}.
 */
public interface HeroRepository extends MongoRepository<Hero, String> {

   /**
     * Method to retrieve hero´s data filtering by id.
     * 
     * @param heroId of the hero.
     * 
     * @return An instance of the type {@link Hero} with the information related.
     * 
    */
	Hero findByHeroId(Integer heroId);
}
