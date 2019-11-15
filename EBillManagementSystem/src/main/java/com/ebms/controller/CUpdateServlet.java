package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Customer1;
import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class CUpdateServlet
 */
public class CUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(CUpdateServlet.class);
    public CUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CustDaoImpl cdao=new CustDaoImpl();
		PrintWriter pw=response.getWriter();
		Customer1 cs=new Customer1();
		//pw.println("<a href=student.html>update</a>");
		
		String no=request.getParameter("cid");
		int cid=Integer.parseInt(no);
		cs=cdao.viewCustomer(cid);
		response.setContentType("text/html");
		pw.println("<table border='3'>");
		if(cs!=null)
		{
		pw.println("<table align=center cellspacing=10px cellpadding=5px>");
		pw.println("<form action=CUpdServlet>");
		pw.println("<tr><td>Customer id:</td><td><input type='text' readonly name=cid value="+cs.getCid()+"></td></tr><br>");
		pw.println("<tr><td>Customer Name:</td><td><input type='text' name=cname value="+cs.getCname()+"></td></tr><br>");
		pw.println("<tr><td>Customer Address:</td><td><input type='text' name=cadd value="+cs.getCadd()+"></td></tr><br>");
		pw.println("<tr><td>Customer Mobile:</td><td><input type='text' name=cmobile value="+cs.getCmobile()+"></td></tr><br>");
		pw.println("<tr><td>Customer Email:</td><td><input type='text' name=cemail value="+cs.getCemail()+"></td></tr><br>");
		pw.println("<tr><td>Connection Type:</td><td><select name='ctype' value="+cs.getCtype()+"><option>--select--</option><option>Residential</option><option>Industrial</option><option>Organisation</option></select></td></tr>");
		pw.println("<tr><td>Customer Service id:</td><td><input type='text' name=csid value="+cs.getCsid()+"></td></tr><br>");
		pw.println("<tr><td></td><td><input type='submit' name=submit value=update></td></tr><br>");
		pw.println("</form>");
		pw.println("</table>");

		}
	}

}
