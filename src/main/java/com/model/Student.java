package com.model;

import java.util.Date;
public class Student {

	private int id;
	private String name;
	private double marks;
	private Date dob;
	
	public Student() {
		super();
	}
	public Student(int id, String name, double marks, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", dob=" + dob + "]";
	}
}
