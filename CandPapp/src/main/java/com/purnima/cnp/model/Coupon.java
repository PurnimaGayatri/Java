package com.purnima.cnp.model;

import java.math.BigDecimal;

public class Coupon {

	private int id;
	private String code;
	private BigDecimal discount;
	private String exp_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "<h2>Coupon Date</h2> <br/>id:" + id + "<br/> code=" + code + "<br/>discount=" + discount
				+ "<br/>exp_date=" + exp_date;
	}
}
