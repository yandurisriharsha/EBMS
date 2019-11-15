package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.UnitPrice;
import com.ebms.dao.UnitPriceDao;
import com.ebms.utility.ConnectionManager;


public class UnitPriceDaoImpl implements UnitPriceDao {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private static final Logger logger = LogManager.getLogger(UnitPriceDaoImpl.class);
	public int add(UnitPrice up) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into unitdetails(ctype,unitprice) values(?,?)");
			ps.setString(1, up.getCtype());
			ps.setInt(2, up.getUnitprice());
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

	public List<UnitPrice> viewAllrecords() {
		List<UnitPrice> unit=new ArrayList<UnitPrice>();
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select ctype,unitprice from unitdetails");
			rs=ps.executeQuery();
			while(rs.next())
			{
				UnitPrice upp=new UnitPrice(rs.getString(1),rs.getInt(2));
				unit.add(upp);
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
		return unit;
	}

	public UnitPrice unitSpecific(String ctype)
	{
		UnitPrice up=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select ctype,unitprice from unitdetails where ctype=?");
			ps.setString(1, ctype);
			rs=ps.executeQuery();
			while(rs.next())
			{
				up=new UnitPrice(rs.getString(1),rs.getInt(2));
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
		return up;
		
	}
	
	public int update(String ctype,int unitprice) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("update unitdetails set unitprice=? where ctype=? ");
			ps.setInt(1, unitprice);
			ps.setString(2, ctype);
		count=	ps.executeUpdate();
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
