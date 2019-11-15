package com.ebms.dao;

import java.util.List;

import com.ebms.bean.Payment;
import com.ebms.bean.Payment1;

public interface PaymentDao {

	public int addPayment(Payment p);
	public List<Payment1> viewPayments();
	public Payment1 viewSpecPayment(int bid);
	public int deletePayment(int pid);
}
