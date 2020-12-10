package com.infy.orderms.validator;

import com.infy.orderms.entity.Order;

public class OrderValidator {

public static void ValidateOrderForAdding(Order order) throws Exception{
	
	if(!isValidOrderDeliveryAddress(order.getAddress())) 
	{
		throw new Exception("Delivery Address should be within 100 characters");
	}
}
	public static Boolean isValidOrderDeliveryAddress(String address)
	{
		Boolean flag = false;
		if(address.length()<100)
			flag=true;
		return flag;
		
	}
}
