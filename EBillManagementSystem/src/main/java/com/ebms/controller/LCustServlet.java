package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.LCustomer;
import com.ebms.daoImpl.CustDaoImpl;

/**
 * Servlet implementation class LCustServlet
 */
public class LCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(LCustServlet.class);
    public LCustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		CustDaoImpl cdao=new CustDaoImpl();
		String cuserid=request.getParameter("cuserid");
		String cpwd=request.getParameter("cpwd");
		LCustomer lc=new LCustomer(cuserid,cpwd);
		int count=cdao.addCustomerLogin(lc);
		if(count!=0)
		{
			out.println("Registered");
			logger.info("Registered");
			RequestDispatcher rd=request.getRequestDispatcher("CLogin.html"); 
			rd.forward(request, response);
			/*out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>EBMS</title>");
			out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<div width=100%>");
			RequestDispatcher rd=request.getRequestDispatcher("link.html"); 
			rd.include(request, response);
			out.println("</div>");
			
			out.println("<div>");
			ServletContext sct=request.getServletContext();
			int csid=(Integer) sct.getAttribute("sid");
			//out.println("<div width=30% margin-top=500px>");
			out.println("<table border=3px cellpadding=10px cellspacing=5px>");
			out.println("<tr><th>Your Generated URSC Id:</th></tr><tr><td>" + csid + "</td></tr>");
			out.println("</table>");
			out.println("</div>");
			out.println("<div>");
			out.println("<button><a href='CLogin.html'>Login</a></button>"); 
			out.println("</div>");
			out.println("<div width='100%' height='100px'>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</div>");			
			out.println("</body>");
			out.println("</html>");
			
			//out.println("Registered Successfully");
			logger.info("Registered Successfully");
			out.println("<button><a href='CLogin.html'>Login</a></button>"); 
			*/
		}
		else
		{
			out.println("Not Registered");
			logger.info("Not Registered");
			RequestDispatcher rd=request.getRequestDispatcher("lcust.html"); 
			rd.forward(request, response);
		}
	}

}
