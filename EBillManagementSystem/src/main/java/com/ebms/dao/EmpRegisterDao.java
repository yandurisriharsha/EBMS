package com.ebms.dao;

import com.ebms.bean.Empolyee;

public interface EmpRegisterDao {

	//public int register(Empolyee emp);
	public boolean login(String euserid,String epwd);
	public void forgotPassword(String emobile);
}
