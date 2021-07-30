package com.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="empid")
     int empid;
	@Column(name="empname")
     String name;
	@Column(name="age")
     int age;
	@Column(name="city")
     String city;
     public Employee() {
    	 
     }
	public Employee(int empid, String name, int age, String city) {
		super();
		this.empid = empid;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
     
}
