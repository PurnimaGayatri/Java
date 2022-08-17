package com.purnima.cnp.model;

import java.math.BigDecimal;

public class Product {

	private int Id;
	private String name;
	private String description;
	private BigDecimal price;
	private String couponCode;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", couponCode=" + couponCode + "]";
	}
}
