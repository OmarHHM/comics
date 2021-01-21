package com.albo.comics.util;

import java.math.BigInteger;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.albo.comics.model.URIData;
import com.fasterxml.jackson.databind.ObjectMapper;
 

public class Util {
	private static final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();

	public static String getHash(String input) 
    { 
        try { 
        	
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

	public static int getId(String name,URIData property ) {
		return Integer.valueOf(Constants.IROMAN.equals(name)?property.getIdIroman():property.getIdCapAmerica());
	}

	public static String getName(String name) {
		return Constants.IROMAN.equals(name)?"Iron Man":"Captain America";
	}
	
	
	public static <T> Predicate<T> distinctByKey(
		    Function<? super T, ?> keyExtractor) {
		    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
		    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
		}
	
	public static String  connectionAPI(String id, URIData property) 
				throws InterruptedException, ExecutionException,
				       ApiException {
		final var factory = new DefaultUriBuilderFactory(property.getBaseURI());
		final var uri = factory.uriString(property.getCharacters()+"/"+id+"/"+property.getComics())
				  .queryParam("ts",property.getTs())
				  .queryParam("apikey",property.getPkPu())
				  .queryParam("hash",Util.getHash(property.getTs()+property.getPkPr()+property.getPkPu()))
				  .build();
		var req = HttpRequest.newBuilder(uri).GET().build();
		var response = client.sendAsync(req, BodyHandlers.ofString());
		//response.thenAccept(res -> System.out.println("el resultado de="+res));
		if(response.get().statusCode() == 200) {
			return response.get().body();			
		}else {
			throw new ApiException(response.get().body());
		}
	}	
	
	public static String getDatetime() {
		   var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   var now = LocalDateTime.now();  
		   return dtf.format(now);  
	}
}
