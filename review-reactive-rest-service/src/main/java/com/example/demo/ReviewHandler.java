package com.example.demo;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.entity.Reviews;
import com.example.demo.ifaces.ReviewsRepository;
import com.example.demo.services.ReviewService;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.List;


@Configuration
public class ReviewHandler {

	    @Autowired
	    private ReviewService service;
	   
	    
	    @Bean
	    RouterFunction<ServerResponse> getAllReviewsRoute() {
	      return route(GET("/reviews"), 
	        req -> ok().body(
	          service.findAllReviews(), Reviews.class));
	    }

//	    @Bean
//	    RouterFunction<ServerResponse> getReviewByIdRoute() {
//	      return route(GET("/employees/{id}"), 
//	        req -> ok().body(
//	          service.findReviewsById(req.pathVariable("id")), Reviews.class));
//	    }
//	

	    
//	    @Bean
//	    RouterFunction<ServerResponse> composedRoutes() {
//	      return 
//	          route(GET("/employees"), 
//	            req -> ok().body(
//	              ReviewsRepository().findAllEmployees(), Employee.class))
//	            
//	          .and(route(GET("/employees/{id}"), 
//	            req -> ok().body(
//	              ReviewsRepository().findEmployeeById(req.pathVariable("id")), Employee.class)))
//	            
//	          .and(route(POST("/employees/update"), 
//	            req -> req.body(toMono(Employee.class))
//	                      .doOnNext(ReviewsRepository()::updateEmployee)
//	                      .then(ok().build())));
//	    }
	

}
