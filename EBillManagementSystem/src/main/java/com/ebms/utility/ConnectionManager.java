package com.ebms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionManager {
/**
 * 
 * @author DELL
 * Class:This class helps to maintain the mysql datbase connection with th project   
 */

	private static Connection con=null;
	//user defined method
	private static final Logger logger = LogManager.getLogger(ConnectionManager.class);
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver registered with DriverManager");
		logger.info("Driver registered with DriverManager");
		
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebms","root","root");

if(con!=null)
	logger.info("Connection is established");
else
	logger.info("Connection is not established");
		
		return con;
	}
	
	
	public static void release(Connection con,PreparedStatement ps) throws SQLException
	{
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
	}
	
	public static void release(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException
	{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
	}

}
