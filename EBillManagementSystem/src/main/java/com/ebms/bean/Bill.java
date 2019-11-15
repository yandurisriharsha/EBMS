package com.ebms.bean;

public class Bill {
private int bid;
private String date;
private int cid;
private String cname;
private String cadd;
private Long cmobile;
private String ctype;
private int csid;
private int units;
private long totbill;
private String status;


public Bill() {
	super();
	// TODO Auto-generated constructor stub
}

public Bill(int bid, String date, int csid, int units, long totbill, String status) {
	super();
	this.bid = bid;
	this.date = date;
	this.csid = csid;
	this.units = units;
	this.totbill = totbill;
	this.status = status;
}

public Bill(String date, int csid, int units, long totbill,String Status) {
	super();
	this.date = date;
	this.csid = csid;
	this.units = units;
	this.totbill = totbill;
	this.status = status;
	}



public Bill(int bid, String date, int cid, String cname, String cadd, int csid, Long cmobile,String ctype, int units, long totbill, String status) {
	super();
	this.bid = bid;
	this.date = date;
	this.cid = cid;
	this.cname = cname;
	this.cadd = cadd;
	this.cmobile = cmobile;
	this.ctype = ctype; 
	this.csid = csid;
	this.units = units;
	this.totbill = totbill;
	this.status = status;
}





/*public Bill(int int1, String string, int int2, String string2, String string3, int int3, long long1, int int4,
		long long2) {
	// TODO Auto-generated constructor stub
}*/
public int getBid() {
	return bid;
}
public String getCtype() {
	return ctype;
}

public void setCtype(String ctype) {
	this.ctype = ctype;
}

public void setBid(int bid) {
	this.bid = bid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getCsid() {
	return csid;
}
public void setCsid(int csid) {
	this.csid = csid;
}
/*public String getCname() {
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
public int getCsid() {
	return csid;
}
public void setCsid(int csid) {
	this.csid = csid;
}*/
public int getUnits() {
	return units;
}
public void setUnits(int units) {
	this.units = units;
}
public long getTotbill() {
	return totbill;
}
public void setTotbill(long totbill) {
	this.totbill = totbill;
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
public Long getCmobile() {
	return cmobile;
}
public void setCmobile(Long cmobile) {
	this.cmobile = cmobile;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}
