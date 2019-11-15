package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class CUpdServlet
 */
public class CUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CUpdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CustDaoImpl cdao=new CustDaoImpl();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("cid");
		int cid=Integer.parseInt(id);
		String cname=request.getParameter("cname");
		String cadd=request.getParameter("cadd");
		String mobile=request.getParameter("cmobile");
		Long cmobile=Long.parseLong(mobile);
		String cemail=request.getParameter("cemail");
		String ctype=request.getParameter("ctype");
		cdao.updateCustomer(cid, cname, cadd, cmobile, cemail, ctype);
		pw.println("<a href=CustViewServlet>Home</a>");
	}

}
