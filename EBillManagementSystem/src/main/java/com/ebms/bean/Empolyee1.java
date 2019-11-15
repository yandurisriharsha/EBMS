package com.ebms.bean;

public class Empolyee1 {

	private int eid;
	private String ename;
	private String eadd;
	private long emobile;
	private String eprofile;
	public Empolyee1(int eid, String ename, String eadd, long emobile, String eprofile) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eadd = eadd;
		this.emobile = emobile;
		this.eprofile = eprofile;
	}
	public Empolyee1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public long getEmobile() {
		return emobile;
	}
	public void setEmobile(long emobile) {
		this.emobile = emobile;
	}
	public String getEprofile() {
		return eprofile;
	}
	public void setEprofile(String eprofile) {
		this.eprofile = eprofile;
	}
	
	
}
