package com.infy.orderms.dto;

import java.util.Date;

import com.infy.orderms.entity.Order;

public class OrderDTO {

	private Integer orderId;
	private Integer buyerId;
	private Double amount;
	private Date date;
	private String address;
	private String status;
	private Double rewardPtsTobeadded;
	private String message;


	public Double getRewardPtsTobeadded() {
		return rewardPtsTobeadded;
	}
	public void setRewardPtsTobeadded(Double rewardPtsTobeadded) {
		this.rewardPtsTobeadded = rewardPtsTobeadded;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static OrderDTO valueOf(Order order)
	{
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setBuyerId(order.getBuyerId());
		orderDTO.setAmount(order.getAmount());
		orderDTO.setDate(order.getDate());
		orderDTO.setAddress(order.getAddress());
		orderDTO.setStatus(order.getStatus());
		return orderDTO;
		
	}
	
	public Order createEntity()
	{
		Order ord= new Order();
		ord.setOrderId(this.getOrderId());
		ord.setBuyerId(this.getBuyerId());
		ord.setAmount(this.getAmount());
		ord.setDate(this.getDate());
		ord.setAddress(this.getAddress());
		ord.setStatus(this.getStatus());
		
		return ord;
	}
}
