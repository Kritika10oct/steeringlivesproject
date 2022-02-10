package com.steering.assignment.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	
	@Id
	//@Max(9999999999)
	@Size(min = 4 , max = 10)
	private  String Id;
	private String name;
	@Column(unique = true)
	private String phoneNo;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	

}