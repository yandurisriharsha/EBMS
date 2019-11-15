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

import com.ebms.daoImpl.EmpRegisterDaoImpl;
import com.ebms.utility.ConnectionManager;


public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @author DELL
	 * Desc:This servlet gets empolyee login credentials and pass the parameters to jdbc implementation
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(EmpLoginServlet.class);
    public EmpLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		EmpRegisterDaoImpl erdao=new EmpRegisterDaoImpl();
		String euserid=request.getParameter("euserid");
		String epwd=request.getParameter("epwd");
		ServletContext cs = getServletContext();
		cs.setAttribute("auth1", euserid);
		boolean flag=erdao.login(euserid, epwd);
		if(flag)
		{
			System.out.println("login successfully");
			out.println("Login Succesfully");
			logger.info("Login Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("empolyee.html"); 
			rd.forward(request, response);
		}
		else
		{
			out.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("ELogin.html"); 
			rd.include(request, response);
			out.println("</div>");
			out.println("<div margin-left='100px' font-color='red'>");
			out.println("<h3>Invalid username and password</h3>");
			logger.info("Invalid username and password");
			out.println("</div>");
		}
	}

}
