package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;

@SpringBootApplication
public class CustomerHateosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerHateosServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {

				 repo.save(new Customer(101,"Ramesh","ram@abc.com"));
				 repo.save(new Customer(102,"Rajesh","raj@abc.com"));
				 repo.save(new Customer(103,"Rakesh","rak@abc.com"));
				 
				 
			}
		};
	}
}
