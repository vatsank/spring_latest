package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.ClientService;

@SpringBootApplication
public class ProductRestClientServiceApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext ctx =	SpringApplication.run(ProductRestClientServiceApplication.class, args);
	
	
      ClientService service =ctx.getBean(ClientService.class);
      
       
      service.fetchItems();
      
      service.addItem(new ItemDto(1010,"printer", 2, 23444));
	      
	     ctx.close();
	
	}

	

}
