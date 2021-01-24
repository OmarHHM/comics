package com.albo.comics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.albo.comics.model.Hero;
import com.albo.comics.repository.HeroRepository;
import com.albo.comics.util.Util;

@Service
public class HeroServiceImpl implements HeroService {

	
    @Autowired
    private Environment env;
	  
	@Autowired	
	private HeroRepository repository;
	
	@Override
	public Hero getCollaborators(final String heroe){
				
	 Hero response = repository.findByHeroId(Util.getId(heroe,env));	
	 if(null!= response) {
		 response
		   .setCharacters(null);		 
	 }	
	 return response;	
	}

	@Override
	public Hero getCharacters(final String heroe) {

		Hero response = repository.findByHeroId(Util.getId(heroe,env));		
	    if(null!= response) {
			response
			  .setColorists(null)
			  .setEditors(null)
			  .setWriters(null);
	    }
		return response;
		
	}

}
