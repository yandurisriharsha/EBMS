package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Bill;
import com.ebms.daoImpl.BillDaoImpl;

/**
 * 
 * @author DELL
 * Desc:This servlet used to generate the current bill for customer by employee
 */
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(BillServlet.class);
	
	public BillServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		BillDaoImpl bdao = new BillDaoImpl();
		int id=bdao.billid();
		int bid=id+1;		
		ServletContext cs = getServletContext();
		cs.setAttribute("id", bid);
		String date = request.getParameter("date");
		String id1 = request.getParameter("csid");
		int csid = Integer.parseInt(id1);
		int up=	bdao.unitPriceDetails(csid);
		String id3 = request.getParameter("units");
		int units = Integer.parseInt(id3);
		int unit = up;
		Long totbill;
		totbill = (long) (units * unit);
		String status="Notpaid";
		Bill b = new Bill(bid,date, csid, units, totbill, status);
		/*out.println("<br>");
		out.println("<table border=3px cellpadding=10px cellspacing=5px>");
		out.println("<tr><th>Total Bill</th></tr><tr><td>" + b.getTotbill() + "</td></tr>");
		out.println("</table>");
		out.println("<br>");
*/
		int count = bdao.addBill(b);
		if (count != 0) {
			out.println("Inserted");
			logger.info("Inserted");
			request.getRequestDispatcher("ViewSpecBillServlet").forward(request, response);
			/*out.println("You can Print bill here");
			out.println("<button type='submit' class='btn btn-default'><a href='ViewSpecBillServlet'>Print</a></button>");
		*/} else {
			out.println("Not Inserted");
			logger.info("Not Inserted");

		}
	}

}
