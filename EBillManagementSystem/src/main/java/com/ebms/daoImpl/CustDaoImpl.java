package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Customer;
import com.ebms.bean.Customer1;
import com.ebms.bean.LCustomer;
import com.ebms.dao.CustDao;
import com.ebms.utility.ConnectionManager;

public class CustDaoImpl implements CustDao {
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
private static final Logger logger = LogManager.getLogger(CustDaoImpl.class);

	public int addCustomer(Customer cs) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into custdetails(cname,cadd,cmobile,cemail,ctype,csid) values(?,?,?,?,?,?)");
			//ps.setInt(1,cs.getCid());
			ps.setString(1, cs.getCname());
			ps.setString(2, cs.getCadd());
			ps.setLong(3,cs.getCmobile());
			ps.setString(4, cs.getCemail());
			ps.setString(5, cs.getCtype());
			ps.setInt(6, cs.getCsid());
			count=ps.executeUpdate();
			if(count!=0)
				System.out.println("customer is successfully added");
			else
				System.out.println("customer is not registered ");
			
			
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
	
	public int addCustomerLogin(LCustomer lc) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into customerlogindetails(cuserid,cpwd) values(?,?)");
			ps.setString(1,lc.getCuserid());
			ps.setString(2, lc.getCpwd());
			
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
	public List<Integer>  retrive() {
		// TODO Auto-generated method stub
		List<Integer>addCustomer=new ArrayList<Integer>();
		
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("select csid from custdetails");
				rs=ps.executeQuery();
				while(rs.next())
				{
				
					addCustomer.add(rs.getInt(1));
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
					ConnectionManager.release(con, ps,rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return addCustomer;
			}
	
		
		//return addCustomer;
		
	public List<Customer1> viewAllCustomers() {
		List<Customer1> viewCustomers=new ArrayList<Customer1>();
		
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("select * from custdetails");
				rs=ps.executeQuery();
				while(rs.next())
				{
					Customer1 cs=new Customer1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getInt(7));
/*					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(7));
*/					viewCustomers.add(cs);
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
		
		return viewCustomers;
	}
	
	public List<Customer1> viewAllECustomers(String euserid){
		List<Customer1> viewECustomers=new ArrayList<Customer1>();
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select c.cid,c.cname,c.cadd,c.cmobile,c.cemail,c.ctype,c.csid from custdetails c,empdetails e,emplogindetails el where c.cadd=e.eadd and e.eid=el.eid and el.euserid=?");
			ps.setString(1, euserid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Customer1 cs=new Customer1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getInt(7));
				//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(7));
					viewECustomers.add(cs);
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
				ConnectionManager.release(con, ps ,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return (List<Customer1>) viewECustomers;
		
	}

	public Customer1 viewCustomer(int cid) {
		Customer1 cs1=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from custdetails where cid=?");
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				cs1=new Customer1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			
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
				ConnectionManager.release(con, ps ,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		return cs1;
	}

	public int updateCustomer(int cid,String cname,String cadd,long cmobile,String cemail,String ctype) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("update custdetails set cname=?,cadd=?,cmobile=?,cemail=?,ctype=? where cid=?");
			ps.setString(1, cname);
			ps.setString(2, cadd);
			ps.setLong(3, cmobile);
			ps.setString(4, cemail);
			ps.setString(5, ctype);
			ps.setInt(6, cid);
			count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("Updated");
				logger.info("Updated");
			}
			else
			{
				System.out.println("Not Updated");
				logger.info("Not Updated");
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

	public int deleteCustomer(int cid) {
		int count=0;
		
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("delete from custdetails where cid=?");
				ps.setInt(1, cid);
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
	public int CustServiceId()
	{
		
		int id=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select max(csid) from custdetails");
			rs=ps.executeQuery();
			while(rs.next())
			{
				 id=rs.getInt(1);
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
				ConnectionManager.release(con, ps ,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return id;
		
	}

}
