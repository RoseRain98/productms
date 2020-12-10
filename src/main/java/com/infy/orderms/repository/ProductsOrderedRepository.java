package com.infy.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.orderms.entity.ProductsOrdered;

public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, Integer>{

}
