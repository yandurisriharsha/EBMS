package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Customer;
import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(CustomerServlet.class);
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		CustDaoImpl cdao=new CustDaoImpl();
		String cname=request.getParameter("cname");
		String cadd=request.getParameter("cadd");
		String mobile=request.getParameter("cmobile");
		Long cmobile=Long.parseLong(mobile);
		String cemail=request.getParameter("cemail");
		String ctype=request.getParameter("ctype");
		int id=cdao.CustServiceId();
		int csid=id+1;
		Customer c=new Customer(cname,cadd,cmobile,cemail,ctype,csid);
		int count=cdao.addCustomer(c);
		if(count!=0)
		{
			out.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("lcust.html"); 
			rd.include(request, response);
			logger.info("Registered Successfully");
			out.println("</div>");
			out.println("<span>");
			out.println("</span>");
			out.println("<div>");
			out.println("<h4>Your generated URSC code:"+csid+"</h4>");
			out.println("<h3><b>Note:To Activate your URSC code,Please Crete Your username and password or else your code will be deactivated</b></h3>");
			out.println("</div>");
			
		}
		else
		{
			out.println("Not Registered");
			logger.info("Not Registered");
			RequestDispatcher rd=request.getRequestDispatcher("cregister.html"); 
			rd.forward(request, response);
		}
	}

}
