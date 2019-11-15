package com.ebms.dao;

import java.util.List;

import com.ebms.bean.Customer;
import com.ebms.bean.Customer1;
/**
 * 
 * @author DELL
 *
 */
public interface CustDao {
	
	public int addCustomer(Customer cs);
	public List<Customer1> viewAllCustomers();
	public Customer1 viewCustomer(int cid);
	public int updateCustomer(int cid,String cname,String cadd,long mobile,String email,String ctype);
	public int deleteCustomer(int cid);
	

}
