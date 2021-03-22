package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ClientController {

	
	@Autowired
	private WebClient client;
	private String  message;


	@GetMapping(path = "/client/items")
	public String getInfo() {
		
	    	 Mono<String> bodyMono = client.get()
	    		     .uri("lb://PRODUCT-SERVICE/api/v1/items")
	    		     .accept(MediaType.APPLICATION_JSON)
	    		     .retrieve()
	    		     .bodyToMono(String.class);
	    	 bodyMono.subscribe( s -> this.message = s);
	   
	    	 return  this.message;
	    		 

	    }


}
