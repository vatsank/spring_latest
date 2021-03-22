package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.respos.ItemRepository;
import java.util.*;

import javax.management.RuntimeErrorException;

import com.example.demo.entity.*;
@Service
public class ItemService {

	
	@Autowired
	private ItemRepository repo;


	public List<Item> getAll(){
		
		System.out.println(repo.getClass());
		
		return this.repo.findAll();
	}
	
	
	public Item addItem(Item entity) {
		
		return this.repo.save(entity);
	}
	
	public Item findByItemId(Long id) {
		
		
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found"));
	}
	
	
	public List<Item> findByName(String srchName){
		
		return this.repo.findByName(srchName);
	}
	
	
	
	public List<Item> findQuanityGrt(int qty){
		
		return this.repo.findItemByQuntityGt(qty);
	}
	
	public void updatePrice(){
		
		 this.repo.updatePrice();
	}
	
	public void remove(long id) {
		
		this.repo.deleteById(id);
	}
}
