package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.dao.CSRegisterDao;
import com.ebms.utility.ConnectionManager;

public class CSRegisterDaoImpl implements CSRegisterDao {
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
private static final Logger logger = LogManager.getLogger(CSRegisterDaoImpl.class);

	public boolean login(String cuserid, String cpwd) {
		boolean flag=false;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from customerlogindetails where cuserid=? and cpwd=?");
			ps.setString(1, cuserid);
			ps.setString(2, cpwd);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;
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
		
		return flag;
	}

	public boolean forgotPassword(String cemail) {
		
boolean flag=false;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from custdetails where cemail=?");
			ps.setString(1, cemail);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;
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
		
		return flag;

	}

}
