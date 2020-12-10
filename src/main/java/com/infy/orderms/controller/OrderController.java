package com.infy.orderms.controller;




import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.orderms.dto.CartDTO;
import com.infy.orderms.dto.OrderDTO;
import com.infy.orderms.dto.ProductDTO;
import com.infy.orderms.entity.ProductsOrdered;
import com.infy.orderms.service.OrderService;

@RestController
@EnableAutoConfiguration
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Value("${product.uri}")
	String productUri;
	@Value("${user.uri}")
	String userUri;
	
	@PostMapping(value = "/orders")
	public String addOrder(@RequestBody OrderDTO orderDTO) throws Exception
	{
		return orderService.addOrder(orderDTO).getMessage();
	}
	
	@GetMapping(value = "/orders/orderId/{orderId}")
	public String removeOrder(@PathVariable Integer orderId)
	{
		return orderService.removeOrder(orderId);
	}
	
	@GetMapping(value = "/orders/viewallorders")
	public List<OrderDTO> viewAllOrders() 
	{
		return orderService.viewOrders();
	}
	
	@PostMapping(value = "/orders/updatestatus")
	public String updateStatus(@RequestParam(name = "orderid")Integer orderId,@RequestParam(name = "status") String status) 
	{
		return orderService.updateStatusForOrder(orderId, status);
	}
	@GetMapping(value = "/orders/addingcartproducttoorder")
	public OrderDTO addCartToOrders() throws Exception {
		OrderDTO pod = null;
		CartDTO cartdto = new RestTemplate().getForObject(userUri+"/addressforcart",CartDTO.class);
		ProductDTO productDTO = new RestTemplate().getForObject(productUri +"/productId/"+cartdto.getProdId(),ProductDTO.class);
		Double price = productDTO.getPrice();
		Integer quantity = cartdto.getQuantity();
		Double total = price*quantity;
		pod.setAddress(cartdto.getAddress());
		pod.setAmount(total);
		pod.setBuyerId(cartdto.getBuyerId());
		Date date =new Date();
		pod.setDate(date);
		pod.setOrderId(orderService.viewOrders().size()+1);
		pod.setStatus("ORDER PLACED");
		pod.setRewardPtsTobeadded(total/100);
		
		return orderService.addOrder(pod);
	}
	@GetMapping(value = "/orders/reorder")
	public String reOrder(@RequestBody Integer orderId) throws Exception
	{
		
		return orderService.reorder(orderId);
	}
	@GetMapping(value = "/orders/subscribedproducts")
	public List<ProductsOrdered> viewAllSubscribedProducts(){
		return orderService.viewSubscribedProducts();
	}
	
}
