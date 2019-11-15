package com.ebms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Bill;
import com.ebms.controller.UnitInsertServlet;
import com.ebms.dao.BillDao;
import com.ebms.utility.ConnectionManager;

public class BillDaoImpl implements BillDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private static final Logger logger = LogManager.getLogger(BillDaoImpl.class);

	public int addBill(Bill b) {
		int count = 0;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(
					"insert into billdetails(bid,date,csid,units,totbill,status) values(?,?,?,?,?,?)");
			ps.setInt(1, b.getBid());
			ps.setString(2, b.getDate());
			ps.setInt(3, b.getCsid());
			ps.setInt(4, b.getUnits());
			ps.setLong(5, b.getTotbill());
			ps.setString(6, b.getStatus());
			DateFormat df = new SimpleDateFormat("dd/MM/yy");
			count = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			logger.error(e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		return count;
	}

	public Bill generateBill(int bid) {
		Bill b = null;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(
					"select b.bid,b.date,c.cid,c.cname,c.cadd,c.csid,c.cmobile,c.ctype,b.units,b.totbill,b.status from billdetails b,custdetails c where b.csid=c.csid and b.bid=?");
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if (rs.next()) {
				b = new Bill(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getLong(7), rs.getString(8), rs.getInt(9), rs.getLong(10), rs.getString(11));
				/*
				 * System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +
				 * "\t" + rs.getInt(3) + "\t" + rs.getString(4) + "\t" +
				 * rs.getString(5) + "\t" + rs.getInt(6) + "\t" + rs.getLong(7)
				 * + "\t" + rs.getInt(8) + "\t" + rs.getLong(9) + "\t" +
				 * rs.getString(10));
				 */

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return b;
	}

	public List<Bill> viewAllBills() {
		List<Bill> viewBills = new ArrayList<Bill>();
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(
					"select b.bid,b.date,c.cid,c.cname,c.cadd,c.csid,c.cmobile,c.ctype,b.units,b.totbill,b.status from billdetails b,custdetails c where c.csid=b.csid");
			rs = ps.executeQuery();
			while (rs.next()) {
				Bill b1 = new Bill(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getLong(7), rs.getString(8), rs.getInt(9), rs.getLong(10), rs.getString(11));
				viewBills.add(b1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return viewBills;
	}

	public int deleteBill(int bid) {
		int count = 0;

		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("delete from billdetails where bid=?");
			ps.setInt(1, bid);
			count = ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return count;
	}

	public Bill viewSpecBill(int csid) {
		Bill b = null;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(
					"select b.bid,b.date,c.cid,c.cname,c.cadd,c.csid,c.cmobile,c.ctype,b.units,b.totbill,b.status from billdetails b,custdetails c where b.csid=c.csid and b.csid=?");
			ps.setInt(1, csid);
			rs = ps.executeQuery();
			while (rs.next()) {
				b = new Bill(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getLong(7), rs.getString(8), rs.getInt(9), rs.getLong(10), rs.getString(11));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return b;
	}

	public int unitPriceDetails(int csid) {
		int up = 0;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(
					"select u.unitprice from unitdetails u,custdetails c where u.ctype=c.ctype and c.csid=?");
			ps.setInt(1, csid);
			rs = ps.executeQuery();
			while (rs.next()) {
				up = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return up;
	}

	public int billid() {
		int id = 0;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("select max(bid) from billdetails");
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return id;
	}

	public void customerServiceId(int csid) {
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("select csid from custdetails");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
