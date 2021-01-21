package com.albo.comics.service;

import static java.util.stream.Collectors.toList;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.albo.comics.model.CharacterModel;
import com.albo.comics.model.Creators;
import com.albo.comics.model.Heroe;
import com.albo.comics.model.URIData;
import com.albo.comics.util.ApiException;
import com.albo.comics.util.Constants;
import com.albo.comics.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private URIData property;
	
	@Override
	public Heroe getColaboratos(String heroe) 
			throws JsonMappingException, JsonProcessingException,
			       InterruptedException, ExecutionException, ApiException {
	    var response=new Heroe();	    
	    response.setName(Util.getName( heroe ));
	    response.setId(Util.getId( heroe , property));
	    getResult(String.valueOf(Util.getId( heroe, property ))
	    		  ,Constants.CREATORS,response);
		return response;
	}

	@Override
	public Heroe getCharacters(String heroe)
			 throws JsonMappingException, JsonProcessingException,
			        InterruptedException, ExecutionException, ApiException {
		var response=new Heroe();
		response.setName(Util.getName( heroe ));
	    response.setId(Util.getId( heroe, property));
	    getResult(String.valueOf(Util.getId( heroe, property))
	    		  ,Constants.CHARACTERS,response);
		return response;
	}
	
	private void getResult(String id,String object,Heroe heroe) 
			throws JsonMappingException, JsonProcessingException,
			       InterruptedException, ExecutionException, ApiException {
			var om = new ObjectMapper();
			var node = om.readTree(Util.connectionAPI(id,property));
			var data= node.path(Constants.DATA);	
			var resultsNode= data.path(Constants.RESULTS);	
			var it= resultsNode.iterator();
			var result= new Creators();
			var characters= new ArrayList<CharacterModel>();
			CharacterModel character;
			Set<String>  editors=new HashSet();
			Set<String>  writers=new HashSet();
			Set<String>  colorist=new HashSet();
			Set<String>  comics=new HashSet();
			var mapper = new ObjectMapper();
			var all = new ArrayList<CharacterModel>();
			Map<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
			var aux = new ArrayList<String>();
			while(it.hasNext()) {
				var jsonNodeIt=  (JsonNode) it.next();
				result=mapper.readValue(jsonNodeIt.path(object).toString(),
									    Creators.class);
				Creators cr = result;
		
				for(var item:cr.getItems()) {						
					if(object.equals(Constants.CREATORS)) {
						switch (item.getRole()) {
							case Constants.EDITORS:
								editors.add(item.getName());
								break;
							case Constants.WRITERS:
								writers.add(item.getName());
								break;
							case Constants.COLORISTS:		
								colorist.add(item.getName());
								break;
							default: break;
						}
						
					}else {
						if(!heroe.getName().equalsIgnoreCase(item.getName()) && null!=item.getName()){
								if(map.containsKey(item.getName())) {
									aux=map.get(item.getName());
									aux.add(jsonNodeIt.findValue("title").toString());
								}else {
									aux = new ArrayList<String>();
									aux.add(jsonNodeIt.findValue("title").toString());
								}
								
								map.put(item.getName(),aux);
							    character= new CharacterModel();
								character.setName(item.getName());
								characters.add(character);								
						} 
					}
				}	
			}
			
			final var collection= 
					characters.stream() 
			  .filter(Util.distinctByKey(chrs -> chrs.getName()))
			  .collect(toList());
			
			
			collection
		  	  .forEach(
		  	    (item)  -> 
		  	  
		  	    {
		  	    	item.setComics( map.entrySet() 
					      .stream() 
					      .parallel()
					      .filter(mapd -> mapd.getKey().equals(item.getName()))
					      .iterator().next().getValue().toArray(String[] ::new));		  	    						      
		  	    }
		  	  );

			all = new ArrayList(collection);
			if(object.equals(Constants.CREATORS)) {
				heroe.setColorists(colorist.toArray(new String[colorist.size()]));
				heroe.setEditors(editors.toArray(new String[editors.size()]));
				heroe.setWriters(writers.toArray(new String[writers.size()]));
			}else {
				heroe.setCharacters(all);
			}
		
	
	}

}
