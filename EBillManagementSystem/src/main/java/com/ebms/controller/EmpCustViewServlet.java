package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebms.bean.Customer1;
import com.ebms.daoImpl.CustDaoImpl;

public class EmpCustViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpCustViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		CustDaoImpl cdao=new CustDaoImpl();
		
		ServletContext sc=getServletContext();
		String euserid=(String) sc.getAttribute("auth1");
		List<Customer1> viewRecords=cdao.viewAllECustomers(euserid);
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE.html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>EBMS</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body onload=reload>");
		out.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("elink.html").include(request, response);
		out.println("</div>");
		
		out.println("<div>");
		out.println("<table class='table table-bordered  table-hover'>");
		out.println("<tr><th>Cid</th><th>Cname</th><th>Cadd</th><th>Cmobile</th><th>Cemail</th><th>Connection type</th><th>Csid</th><th></th></tr>");
		for(Customer1 c:viewRecords)
		{
			out.println("<tr><td>");
			out.println(c.getCid()+"</td><td>"+c.getCname()+"</td><td>"+c.getCadd()+"</td><td>"+c.getCmobile()+"</td><td>"+c.getCemail()+"</td><td>"+c.getCtype()+"</td><td>"+c.getCsid()+"</td><td>"+"<a href=CUpdateServlet?cid="+c.getCid()+">Update</a>");
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
