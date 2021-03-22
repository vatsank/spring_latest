package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ItemService;

import java.util.*;
import com.example.demo.entity.*;
@RestController
@RequestMapping(path = "/api/v1/")

@CrossOrigin(origins = "*")
public class ItemController {

	
	@Autowired
	private ItemService service;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/items" , produces = "application/json")
	public List<Item> findAll(){
		
		System.out.println("Port Number ============="+port);
			return this.service.getAll();
	}
	
	@GetMapping(path = "/items/{id}" , produces = "application/json")
	public Item find(@PathVariable("id") long id){
		
		return this.service.findByItemId(id);
	}
	
	
	@GetMapping(path = "/items/srch/name/{name}" , produces = "application/json")
	public List<Item> find(@PathVariable("name") String name){
		
		return this.service.findByName(name);
	}
	
	
	@GetMapping(path = "/items/srch/qty/{qty}" , produces = "application/json")
	public List<Item> find(@PathVariable("qty") int srchQty){
		
		return this.service.findQuanityGrt(srchQty);
	}
	
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/items" , produces = "application/json",consumes = "application/json")
	public Item addItem(@RequestBody Item item) {
		
		return this.service.addItem(item);
	}
	
	

	
	@PutMapping(path = "/items" , produces = "application/json")
	public void updatePrice(){
		
		 this.service.updatePrice();
	}
	
	@DeleteMapping(path = "/items/{id}" , produces = "application/json")
	public void remove(@PathVariable("id") long id){
		
		this.service.remove(id);
	}
	
}
