package com.ebms.dao;

import java.util.List;

import com.ebms.bean.UnitPrice;

public interface UnitPriceDao {

	public int add(UnitPrice up);
   public List<UnitPrice> viewAllrecords();
   public int update(String ctype,int unitprice);
   
	
}
