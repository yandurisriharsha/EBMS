package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Payment1;
import com.ebms.bean.UnitPrice;
import com.ebms.daoImpl.UnitPriceDaoImpl;

/**
 * Servlet implementation class UnitViewServlet
 */
public class UnitViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		UnitPriceDaoImpl upid=new UnitPriceDaoImpl();
		List<UnitPrice> list1=upid.viewAllrecords();
		response.setContentType("text/html");
		pw.println("<!DOCTYPE.html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>EBMS</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("link.html").include(request, response);
		pw.println("</div>");
		
		pw.println("<div>");
		pw.println("<table class='table table-bordered  table-hover'>");
		pw.println("<tr><th>CType</th><th>Unit Price</th><th></th></tr>");
		
		for(UnitPrice up1:list1)
		{
			pw.println("<tr><td>");
			pw.println(up1.getCtype()+"</td><td>"+up1.getUnitprice()+"</td><td>"+"<a href=UUpdateServlet?ctype="+up1.getCtype()+">Update</a>");
			pw.println("</td></tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("footer.html").include(request, response);
	    pw.println("</div>");
		
		
		pw.println("</body>");
		pw.println("</html>");
	}

	}

	

