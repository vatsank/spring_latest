package com.example.demo.services;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.entity.Reviews;
import com.example.demo.ifaces.ReviewsRepository;

import reactor.core.publisher.*;


@Service
public class ReviewService {

	
	@Autowired
	private ReviewsRepository repo;
	
    public Mono<Reviews> findReviewsById(int id)
    {
        return Mono.just(repo.findById(id).get());
    }
    
    public Flux<Reviews> findAllReviews()
    {
        return Flux.fromIterable(repo.findAll());
    }

}

