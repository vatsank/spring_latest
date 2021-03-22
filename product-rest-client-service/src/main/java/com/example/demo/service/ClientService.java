package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.ItemDto;

import reactor.core.publisher.*;
import java.util.*;
@Component
public class ClientService {

	

	private static WebClient client = WebClient.create("http://localhost:8080/api/v1");
	
	
	public void fetchItems() {
		
		Flux<String> flux =client.get()
		    	.uri("/items")
		    	.retrieve()
		    	.bodyToFlux(String.class);
		    	
		    	
		    	 flux.log().doOnNext(System.out::println).blockLast();
		    	 
	}
	
	public void addItem(ItemDto item) {
		
		 Map<String,Object> object = new HashMap<String,Object>();
	        object.put("itemName",item.getName());
	        object.put("price",item.getPrice());
	        object.put("quantity",item.getQuantity());
	        
	         client
	                .post()
	                .uri("/items")
	                .body(BodyInserters.fromValue(object))
	                .retrieve()
	                .bodyToMono(Void.class).subscribe(System.out::println);
	
	           
			
			
		}

	
	
}


