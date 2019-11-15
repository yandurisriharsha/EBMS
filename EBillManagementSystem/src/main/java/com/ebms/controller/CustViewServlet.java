package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.Customer;
import com.ebms.bean.Customer1;
import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class CustViewServlet
 */
public class CustViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(CustViewServlet.class);
    public CustViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		CustDaoImpl cdao=new CustDaoImpl();
		List<Customer1> viewRecords=cdao.viewAllCustomers();
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE.html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>EBMS</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("link.html").include(request, response);
		out.println("</div>");
		
		out.println("<div>");
		out.println("<table class='table table-bordered  table-hover'>");
		out.println("<tr><th>Cid</th><th>Cname</th><th>Cadd</th><th>Cmobile</th><th>Cemail</th><th>Connection type</th><th>Csid</th><th></th><th></th></tr>");
		for(Customer1 c:viewRecords)
		{
			out.println("<tr><td>");
			out.println(c.getCid()+"</td><td>"+c.getCname()+"</td><td>"+c.getCadd()+"</td><td>"+c.getCmobile()+"</td><td>"+c.getCemail()+"</td><td>"+c.getCtype()+"</td><td>"+c.getCsid()+"</td><td>"+"<a href=CDeleteServlet?cid="+c.getCid()+">Delete</a>"+"</td><td>"+"<a href=CUpdateServlet?cid="+c.getCid()+">Update</a>");
			out.println("</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
