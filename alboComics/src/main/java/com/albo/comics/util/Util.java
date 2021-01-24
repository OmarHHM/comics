package com.albo.comics.util;

import org.springframework.core.env.Environment;
 
public class Util {
  

	public static int getId(String name, Environment env ) {
	  
		return 
		  Integer
		    .valueOf(
		      Constants.IRONMAN.equals(name) 
		        ? env.getProperty("idIroman")
		        : env.getProperty("idCapAmerica"));
		
	}

	public static String getName(String name) {
	  
		return
		  Constants.IRONMAN.equals(name) 
		    ? "Iron Man"
		    : "Captain America";
		
	}
	
}
