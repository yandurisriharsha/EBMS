package com.ebms.bean;

public class LEmpolyee {

	private String euserid;
	private String epwd;
	public LEmpolyee(String euserid, String epwd) {
		super();
		this.euserid = euserid;
		this.epwd = epwd;
	}
	public LEmpolyee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEuserid() {
		return euserid;
	}
	public void setEuserid(String euserid) {
		this.euserid = euserid;
	}
	public String getEpwd() {
		return epwd;
	}
	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}
	
}
