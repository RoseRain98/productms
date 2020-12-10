package com.infy.orderms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productsordered")
public class ProductsOrdered {
	@Id
	@Column(name = "prodordid", nullable = false)
	private Integer productOrderedId;
	@Column(name = "orderid", nullable = false)
	private Integer orderId;
	@Column(name = "prodid", nullable = false)
	private Integer productId;
	@Column(name = "sellerid", nullable = false)
	private Integer sellerId;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "status", nullable = false)
	private String status;
	@Column(name = "price")
	private Double price;
	public Integer getProductOrderedId() {
		return productOrderedId;
	}
	public void setProductOrderedId(Integer productOrderedId) {
		this.productOrderedId = productOrderedId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
