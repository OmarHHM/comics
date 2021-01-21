package com.albo.comics.util;

import java.math.BigInteger;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.web.util.DefaultUriBuilderFactory;

import com.albo.comics.model.URIData;
 
public class Util {
  
	private static final HttpClient CLIENT = HttpClient
	                                           .newBuilder()
	                                           .version(Version.HTTP_2)
	                                           .build();
	
	private static final DateTimeFormatter DTF = DateTimeFormatter
	                                               .ofPattern("yyyy/MM/dd HH:mm:ss");

	public static String getHash(String input) {
	  
    try { 
        	
      final var md = MessageDigest.getInstance("MD5");  
      
      final var messageDigest = md.digest(input.getBytes()); 
      
      final var no = new BigInteger(1, messageDigest); 
   
      var hashtext = no.toString(16); 
      
      while (hashtext.length() < 32) {
        
        hashtext = "0" + hashtext;
        
      } 
      
      return hashtext;
      
    } catch (NoSuchAlgorithmException e) {
      
      throw 
        new RuntimeException(e);
      
    } 
    
  } 

	public static int getId(String name,URIData property ) {
	  
		return 
		  Integer
		    .valueOf(
		      Constants.IROMAN.equals(name) 
		        ? property.getIdIroman()
		        : property.getIdCapAmerica());
		
	}

	public static String getName(String name) {
	  
		return
		  Constants.IROMAN.equals(name) 
		    ? "Iron Man"
		    : "Captain America";
		
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	  
	  var seen = new ConcurrentHashMap<>();
	  
		return 
		  t -> null == seen
		               .putIfAbsent(
		                 keyExtractor.apply(t),
		                 Boolean.TRUE); 
		  
  }
	
	public static String  connectionAPI(String id,
	                                    URIData property) throws InterruptedException,
	                                                             ExecutionException,
				                                                       ApiException {
	  
		final var factory = new DefaultUriBuilderFactory(property.getBaseURI());
		
		final var uri = factory
		                  .uriString(property.getCharacters()+"/"+id+"/"+property.getComics())
                      .queryParam("ts",property.getTs())
				              .queryParam("apikey",property.getPkPu())
				              .queryParam("hash",Util.getHash(property.getTs()+property.getPkPr()+property.getPkPu()))
				              .build();
		
		var req = HttpRequest
		            .newBuilder(uri)
		            .GET()
		            .build();
		
		final var response = CLIENT
		                       .sendAsync(
		                         req,
		                         BodyHandlers.ofString());
		
		if(response.get().statusCode() == 200) {
		  
			return
			  response
			    .get()
			    .body();
			
		} else {
		  
			throw 
			  new ApiException(response.get().body());
			
		}
	}	
	
	public static String getDatetime() {
		
		return 
		  DTF.format(LocalDateTime.now());
		
	}
}
