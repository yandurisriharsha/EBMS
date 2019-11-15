package com.ebms.dao;

import java.util.List;

import com.ebms.bean.Bill;
/**
 * 
 * @author DELL
 * addBill:To add customer bill
 * viewAllBills:to get list of customer bills
 */
public interface BillDao {

	public int addBill(Bill b);
	public Bill generateBill(int bid);
	public List<Bill> viewAllBills();
	public Bill viewSpecBill(int csid);
	
	
}