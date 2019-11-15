package com.ebms.bean;

public class Customer1 {

	private int cid;
	private String cname;
	private String cadd;
	private long cmobile;
	private String cemail;
	private String ctype;
	private int csid;
	public Customer1(int cid, String cname, String cadd, long cmobile, String cemail, String ctype, int csid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cadd = cadd;
		this.cmobile = cmobile;
		this.cemail = cemail;
		this.ctype = ctype;
		this.csid = csid;
	}
	public Customer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public long getCmobile() {
		return cmobile;
	}
	public void setCmobile(long cmobile) {
		this.cmobile = cmobile;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	
}
