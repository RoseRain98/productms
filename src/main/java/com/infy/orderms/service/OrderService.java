package com.infy.orderms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.orderms.dto.OrderDTO;
import com.infy.orderms.entity.Order;
import com.infy.orderms.entity.ProductsOrdered;
import com.infy.orderms.repository.OrderRepository;
import com.infy.orderms.repository.ProductsOrderedRepository;
import com.infy.orderms.validator.OrderValidator;

@Service
public class OrderService {
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	ProductsOrderedRepository por;
	
	public OrderDTO addOrder(OrderDTO orderDTO) throws Exception{
		Order order=orderDTO.createEntity();
		OrderValidator.ValidateOrderForAdding(order);
		orderRepo.save(order);
		orderDTO.setMessage("successfully Added the Order");
		return orderDTO;
	}
	
	public String removeOrder(Integer orderId) {
		Optional<Order> ord1 = orderRepo.findById(orderId);
		if (ord1.isPresent()) 
		{
			orderRepo.deleteById(orderId);
			return "Success";
		}
		return "Failed";
	}
	
	public String updateStatusForOrder(Integer orderId, String status) {
		Optional<Order> ord2 = orderRepo.findById(orderId);
		Order order = null;
		if (ord2.isPresent()) 
		{
			order = ord2.get();
		}
		order.setStatus(status);
		orderRepo.save(order);
		return "Success";
	}
	public List<OrderDTO> viewOrders()
	{
		List<Order> orders= orderRepo.findAll();
	    List<OrderDTO> orderDTOs= new ArrayList<OrderDTO>();
	    
	    for(Order order : orders)
	    {
	    	OrderDTO orderDTO = OrderDTO.valueOf(order);
	    	orderDTOs.add(orderDTO);
	    }
	    logger.info("Order Details: {}", orderDTOs);
	    return orderDTOs;
	}
	public String reorder(Integer orderid) {
		Optional<Order> optord = orderRepo.findById(orderid);
		Order ord = null;
		if(optord.isPresent()) {
			ord = optord.get();
		}
		ord.setOrderId(orderRepo.findAll().size()+1);
		orderRepo.save(ord);
		return "Order is placed";
	}
	public List<ProductsOrdered> viewSubscribedProducts(){
		return por.findAll();
	}
	
}
