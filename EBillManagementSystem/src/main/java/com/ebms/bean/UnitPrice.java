package com.ebms.bean;

public class UnitPrice {

	private String ctype;
	private int unitprice;
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public UnitPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnitPrice(String ctype, int unitprice) {
		super();
		this.ctype = ctype;
		this.unitprice = unitprice;
	}
	
	
}
