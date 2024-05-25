package com.saswat23.sportal.model;

public class Student {
	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Student [userid=" + userid + "]";
	}
	
}
