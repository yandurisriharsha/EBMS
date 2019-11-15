package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.daoImpl.BillDaoImpl;

/**
 * 
 * @author DELL
 * Desc:This servlet help to delete the generated bills 
 */
public class BDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(BDeleteServlet.class);
    public BDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		BillDaoImpl bdao=new BillDaoImpl();
		response.setContentType("text/html");
		String no=request.getParameter("bid");
		int bid=Integer.parseInt(no);
		int count=bdao.deleteBill(bid);
		if(count!=0)
		{
			//pw.println("Data deleted");
			logger.info("Data deleted");
			pw.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("EViewAllBillsServlet"); 
			rd.forward(request, response);
			pw.println("</div>");
			pw.println("<div>");
			pw.println("Data deleted");
			pw.println("</div>");
			//pw.println("<a href=EmpViewServlet>viewRecords</a>");
		}
		else
		{
			//pw.println("Data not Deleted");
			logger.info("Data not Deleted");
			pw.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("EViewAllBillsServlet"); 
			rd.forward(request, response);
			pw.println("</div>");
			pw.println("<div>");
			pw.println("Data not Deleted");
			pw.println("</div>");
		}
	}

}
