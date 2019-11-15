package com.ebms.dao;

import com.ebms.bean.Customer;

public interface CSRegisterDao {

	//public int register(Customer cs);
	public boolean login(String cuserid,String cpwd);
	public boolean forgotPassword(String cemail);
}
