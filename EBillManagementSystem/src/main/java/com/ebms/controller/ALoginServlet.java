package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ALoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @author DELL
	 * Desc:This servlet gets admin login credentials and pass the parameters to Jdbc implementation
	 */
	
	private static final Logger logger = LogManager.getLogger(ALoginServlet.class);
    public ALoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();  
        session.setAttribute("name",username); 
		if(username.equals("admin")&password.equals("admin"))
		{
			pw.println("Login successfully");
			RequestDispatcher rd=request.getRequestDispatcher("admin.html"); 
			rd.forward(request, response);
			logger.info("Login successfully");
		}
		else
		{
			pw.println("Invalid Username and Password");
			logger.info("Invalid Username and Password");
			pw.println("<a href=ALogin.html align=right>Home</a>");
		}
	}

}
