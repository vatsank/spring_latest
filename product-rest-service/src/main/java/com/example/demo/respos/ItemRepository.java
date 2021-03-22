package com.example.demo.respos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Item;
import java.util.*;

import javax.transaction.Transactional;

public interface ItemRepository extends JpaRepository<Item, Long> {

	
	// Custom Query Method Using  MethodNameQuery
	public List<Item> findByName(String name);
	
	
	// Custom Query Using @Query and Native sql query
	@Query(value = "select * from ecomm_product where quantity>:qty",nativeQuery = true)
	public List<Item> findItemByQuntityGt(@Param("qty") int srchqty);
	
	// Customer query with JPQL- Using Class Name and also property Name
	@Query(value="UPDATE Item SET price = price+price*0.10")
	@Modifying
	@Transactional
	public void updatePrice();
	
}
