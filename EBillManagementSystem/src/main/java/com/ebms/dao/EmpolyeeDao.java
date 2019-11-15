package com.ebms.dao;

import java.util.List;

import com.ebms.bean.Empolyee;
import com.ebms.bean.Empolyee1;

public interface EmpolyeeDao {

	public int addEmpolyee(Empolyee emp);
	public List<Empolyee1> viewAllEmpolyees();
	public Empolyee1 viewEmpolyee(int eid);
	public int updateEmpolyee(int eid,String ename,String eadd,long emobile,String eprofile);
	public int deleteEmpolyee(int eid);
	
}
