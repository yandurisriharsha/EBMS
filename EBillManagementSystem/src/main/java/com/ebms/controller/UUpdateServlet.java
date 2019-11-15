package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.UnitPrice;
import com.ebms.daoImpl.UnitPriceDaoImpl;

/**
 * Servlet implementation class UUpdateServlet
 */
public class UUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		UnitPriceDaoImpl dpimpl=new UnitPriceDaoImpl();
		UnitPrice up=new UnitPrice();
		response.setContentType("text/html");
		String ctype=request.getParameter("ctype");
		up=dpimpl.unitSpecific(ctype);
		if(up!=null)
		{
			pw.println("<table border='3' align=center cellspacing=10px cellpadding=5px>");
			pw.println("<form action=UUpdServlet>");
			pw.println("<tr><td>Connection Type:</td><td><select name='ctype' value="+up.getCtype()+"><option>--select--</option><option>Residential</option><option>Industrial</option><option>Organisation</option></select></td></tr><br>");
			pw.println("<tr><td>Unit Price:</td><td><input type='text' name='unitprice' value="+up.getUnitprice()+"></td></tr><br>");
			pw.println("<tr><td></td><td><input type='submit' name=submit value=update></td></tr><br>");
			pw.println("</form>");
			pw.println("</table>");
		}
	}

}
