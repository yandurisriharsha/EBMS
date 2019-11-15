package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class CDeleteServlet
 */
public class CDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(CDeleteServlet.class);
    public CDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		CustDaoImpl cdao=new CustDaoImpl();
		response.setContentType("text/html");
		String no=request.getParameter("cid");
		int cid=Integer.parseInt(no);
		int count=cdao.deleteCustomer(cid);
		if(count!=0)
		{
			pw.println("Data deleted");
			logger.info("Data deleted");
			pw.println("<a href=CustViewServlet>viewRecords</a>");
		}
		else
		{
			pw.println("Data not Deleted");
			logger.info("Data not Deleted");
			pw.println("<a href=CustViewServlet>viewRecords</a>");
		}
	}

}
