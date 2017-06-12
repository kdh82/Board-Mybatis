package com.dgit.member.model;

import java.util.Date;

public class Member {
	private String memberId;
	private String name;
	private String password;
	private	Date regDate;

	public Member() {
		// TODO Auto-generated constructor stub
	}
	

	public Member(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public Member(String memberId, String name, String password, Date regDate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	
	
}
