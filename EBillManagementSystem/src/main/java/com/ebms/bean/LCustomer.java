package com.ebms.bean;

public class LCustomer {

	private String cuserid;
	private String cpwd;
	public LCustomer(String cuserid, String cpwd) {
		super();
		this.cuserid = cuserid;
		this.cpwd = cpwd;
	}
	public LCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCuserid() {
		return cuserid;
	}
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	
}
