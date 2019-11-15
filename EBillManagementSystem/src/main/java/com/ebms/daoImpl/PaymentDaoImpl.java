package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Payment;
import com.ebms.bean.Payment1;
import com.ebms.dao.PaymentDao;
import com.ebms.utility.ConnectionManager;

public class PaymentDaoImpl implements PaymentDao {
Connection con=null;
PreparedStatement ps=null;
PreparedStatement ps1=null;
PreparedStatement ps2=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
private static final Logger logger = LogManager.getLogger(PaymentDaoImpl.class);

	public int addPayment(Payment p) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into paymentdetails(bid,totbill,paying,pmethod,status) values(?,?,?,?,?)");
			//ps.setInt(1, p.getPid());
			ps.setInt(1, p.getBid());
			ps.setLong(2, p.getTotbill());
			ps.setLong(3, p.getPaying());
			ps.setString(4, p.getPmethod());
			ps.setString(5, p.getStatus());
			count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println(" Inserted");
				String st="Paid";
				ps1=con.prepareStatement("update paymentdetails set status=? where bid=?");
				ps1.setString(1, st);
				ps1.setInt(2, p.getBid());
				int count1=ps1.executeUpdate();
				ps2=con.prepareStatement("update billdetails set status=? where bid=?");
				ps2.setString(1, st);
				ps2.setInt(2, p.getBid());
				int count2=ps2.executeUpdate();
			}
			else
			{
				System.out.println(" Not Inserted");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return count;
	}

	public List<Payment1> viewPayments() {
		List<Payment1> viewAllPayments=new ArrayList<Payment1>();
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from paymentdetails");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Payment1 p=new Payment1(rs.getInt(1),rs.getInt(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6));
				viewAllPayments.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return viewAllPayments;
	}

	public Payment1 viewSpecPayment(int bid) {
		Payment1 p=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from paymentdetails where bid=?");
			ps.setInt(1, bid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Payment1(rs.getInt(1),rs.getInt(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return p;
	}

	public int deletePayment(int pid) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from paymentdetails where pid=?");
			ps.setInt(1, pid);
			count=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return count;
	}

}
