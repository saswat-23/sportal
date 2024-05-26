package com.saswat23.sportal.model;

public class Student {
	private String userid;
	private String username;
	private int rollNo;
	private double marks;

	public Student() {}
	
	public Student(String userid, String username, int rollNo, double marks) {
		this.userid = userid;
		this.username = username;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [userid=" + userid + ", username=" + username + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}
	
}
