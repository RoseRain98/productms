package com.infy.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.orderms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
