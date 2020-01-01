package com.sresta.springbootrest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about student")
public class Student {
	
	private String uID;
	@ApiModelProperty(notes="Name must include first and last names")
	private String name;
	private int age;

	public Student() {
	}

	public Student(String uID, String name, int age) {
		super();
		this.uID = uID;
		this.name = name;
		this.age = age;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
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

	@Override
	public String toString() {
		return "Student [uID=" + uID + ", name=" + name + ", age=" + age + "]";
	}

}
