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

import com.ebms.bean.Payment;
import com.ebms.daoImpl.PaymentDaoImpl;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(PaymentServlet.class);
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PaymentDaoImpl pdao=new PaymentDaoImpl();
		PrintWriter pw=response.getWriter();
		/*String id2=request.getParameter("pid");
		int pid=Integer.parseInt(id2);*/
		String id=request.getParameter("bid");
		int bid=Integer.parseInt(id);
		String bill=request.getParameter("totbill");
		Long totbill=Long.parseLong(bill);
		String pd=request.getParameter("paying");
		Long paying=Long.parseLong(pd);
		String pmethod=request.getParameter("pmethod");
		String status="Notpaid";
		if(totbill==paying)
		{
			status="paid";
		}
		Payment p=new Payment(bid,totbill,paying,pmethod,status);
		int count=pdao.addPayment(p);
		if(count!=0)
		{
			pw.println("Data Inserted");
			logger.info("Data Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("cpayments.html"); 
			rd.forward(request, response);
			/*pw.println("<ul>");
			pw.println("<li><a href=PaymentViewSpecServlet>ViewPayments</a></li>");
			pw.println("<li><a href=cpayment.html>Add payments</a></li>");
			pw.println("</ul>");*/
		}
		else
		{
			pw.println("Data Not Inserted");
			logger.info("Data Not Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("cpayment.html"); 
			rd.forward(request, response);
		}
		
	}

}
