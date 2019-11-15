package com.ebms.bean;

public class Empolyee {

private String ename;
private String eadd;
private long emobile;
private String eprofile;

public Empolyee(String ename, String eadd, long emobile, String eprofile) {
	super();
	this.ename = ename;
	this.eadd = eadd;
	this.emobile = emobile;
	this.eprofile = eprofile;
}


public Empolyee() {
	super();
	
}

public String getEprofile() {
	return eprofile;
}
public void setEprofile(String eprofile) {
	this.eprofile = eprofile;
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


}
