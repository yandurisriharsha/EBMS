package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Empolyee;
import com.ebms.bean.Empolyee1;
import com.ebms.bean.LEmpolyee;
import com.ebms.dao.EmpolyeeDao;
import com.ebms.utility.ConnectionManager;

public class EmplDaoImpl implements EmpolyeeDao {

	Connection con=null;
	PreparedStatement ps=null; 
	ResultSet rs=null;
	private static final Logger logger = LogManager.getLogger(EmplDaoImpl.class);
	public int addEmpolyee(Empolyee emp) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into empdetails(ename,eadd,emobile,eprofile) values(?,?,?,?)");
			//ps.setInt(1, emp.getEid());
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getEadd());
			ps.setLong(3, emp.getEmobile());
			ps.setString(4, emp.getEprofile());
			count=ps.executeUpdate();
			if(count!=0)
				System.out.println("employee is successfully registered");
			
			else
				System.out.println("employee is not registered");
			
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
		return count;
	}
	
	public int addEmpolyeeLogin(LEmpolyee le) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into emplogindetails(euserid,epwd) values(?,?)");
			ps.setString(1,le.getEuserid());
			ps.setString(2, le.getEpwd());
			
			count=ps.executeUpdate();
			if(count!=0)
				System.out.println("EmpolyeeLogin are successfully added");
			else
				System.out.println("EmpolyeeLogin is not registered ");
			
			
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

	public List<Empolyee1> viewAllEmpolyees() {
		List<Empolyee1> viewEmployees=new ArrayList<Empolyee1>();
		
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from empdetails");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Empolyee1 e=new Empolyee1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
				viewEmployees.add(e);
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
		return viewEmployees;
	}

	public Empolyee1 viewEmpolyee(int eid) {
		Empolyee1 e=null;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(" select * from empdetails where eid=?");
			ps.setInt(1, eid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				 e=new Empolyee1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
			
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error(e1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error(e1);
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return e;
	}

	public int updateEmpolyee(int eid,String ename,String eadd,long emobile,String eprofile  ) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("update empdetails set ename=?,eadd=?,emobile=?,eprofile=? where eid=?");
			ps.setString(1, ename);
			ps.setString(2, eadd);
			ps.setLong(3, emobile);
			ps.setString(4, eprofile);
			ps.setInt(5, eid);
			count=ps.executeUpdate();
			if(count!=0)
				System.out.println("updtd");
			else
				System.out.println("not updatd");
			
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

	public int deleteEmpolyee(int eid) {
		int count=0;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from empdetails where eid=?");
			ps.setInt(1, eid);
			count=ps.executeUpdate();
			if(count!=0)
				System.out.println("the employee record is deleted successfully");
			else
				System.out.println("the employee record are not deleted ");
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
