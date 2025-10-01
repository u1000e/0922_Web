package com.kh.subway.model.vo;

import java.sql.Date;

public class Subway {
	private String name;
	private String phone;
	private String address;
	private String request;
	private String sandwich;
	private String vegetable;
	private String sauce;
	private String cookie;
	private String payment;
	private Date orderDate;
	public Subway() {
		super();
	}
	public Subway(String name, String phone, String address, String request, String sandwich, String vegetable,
			String sauce, String cookie, String payment, Date orderDate) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.request = request;
		this.sandwich = sandwich;
		this.vegetable = vegetable;
		this.sauce = sauce;
		this.cookie = cookie;
		this.payment = payment;
		this.orderDate = orderDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getSandwich() {
		return sandwich;
	}
	public void setSandwich(String sandwich) {
		this.sandwich = sandwich;
	}
	public String getVegetable() {
		return vegetable;
	}
	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Subway [name=" + name + ", phone=" + phone + ", address=" + address + ", request=" + request
				+ ", sandwich=" + sandwich + ", vegetable=" + vegetable + ", sauce=" + sauce + ", cookie=" + cookie
				+ ", payment=" + payment + ", orderDate=" + orderDate + "]";
	}

}
