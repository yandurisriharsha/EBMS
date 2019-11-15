package com.ebms.bean;

public class Payment {

	private int bid;
	private long totbill;
	private long paying;
	private String pmethod;
	private String status;
	
	public Payment(int bid, long totbill, long paying, String pmethod, String status) {
		super();
		this.bid = bid;
		this.totbill = totbill;
		this.paying = paying;
		this.pmethod = pmethod;
		this.status = status;
	}
	
	
	
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPmethod() {
		return pmethod;
	}
	public void setPmethod(String pmethod) {
		this.pmethod = pmethod;
	}
	
	/*public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}*/
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public long getTotbill() {
		return totbill;
	}
	public void setTotbill(long totbill) {
		this.totbill = totbill;
	}
	public long getPaying() {
		return paying;
	}
	public void setPaying(long paying) {
		this.paying = paying;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
