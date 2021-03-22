package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.*;
import com.example.demo.entity.*;
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	public List<Customer> findByCustomerName(String name);
	
}
