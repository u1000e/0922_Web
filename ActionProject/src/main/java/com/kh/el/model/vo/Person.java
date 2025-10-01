package com.kh.el.model.vo;

public class Person {
	private String name;
	private int age;
	private String address;
	/*
	private String sName;
	
	// ${ student.sName }
	// getSName();
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	*/
	
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
