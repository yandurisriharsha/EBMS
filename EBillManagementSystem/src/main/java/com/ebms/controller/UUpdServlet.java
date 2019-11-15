package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.daoImpl.UnitPriceDaoImpl;

/**
 * Servlet implementation class UUpdServlet
 */
public class UUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UUpdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnitPriceDaoImpl updimpl=new UnitPriceDaoImpl();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String ctype=request.getParameter("ctype");
		String unitprice1=request.getParameter("unitprice");
		int unitprice=Integer.parseInt(unitprice1);
		updimpl.update(ctype, unitprice);
		pw.println("<a href=UnitViewServlet>Home</a>");
		
	}

}
