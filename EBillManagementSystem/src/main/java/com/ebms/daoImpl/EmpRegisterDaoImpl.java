package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.dao.EmpRegisterDao;
import com.ebms.utility.ConnectionManager;

public class EmpRegisterDaoImpl implements EmpRegisterDao {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private static final Logger logger = LogManager.getLogger(EmpRegisterDaoImpl.class);
	public boolean login(String euserid, String epwd) {
		
		boolean flag=false;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from emplogindetails where euserid=? and epwd=?");
			ps.setString(1, euserid);
			ps.setString(2, epwd);
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
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}

	public void forgotPassword(String emobile) {
		// TODO Auto-generated method stub

	}

}
